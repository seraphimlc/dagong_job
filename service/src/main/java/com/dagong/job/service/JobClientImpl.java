package com.dagong.job.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.dagong.job.JobClient;
import com.dagong.job.vo.JobVO;
import com.dagong.mapper.JobMapper;
import com.dagong.pojo.Job;
import com.dagong.service.SearchService;
import com.dagong.user.UserClient;
import com.dagong.util.JobUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/**
 * Created by liuchang on 16/4/24.
 */
@Service(version = "1.0.0")
public class JobClientImpl implements JobClient {

    @Resource
    private SearchService searchService;
    @Resource
    private JobMapper jobMapper;

    @Reference(version = "1.0.0")
    private UserClient userClient;

    private boolean readSwitch = false;


    public JobVO getJobByJobId(String jobId) {
        if (readSwitch) {
            return getJobByJobIdFromDB(jobId);
        } else {
            return getJobByJobIdFromIndex(jobId);
        }
    }

    public JobVO getJobByJobIdFromDB(String jobId) {

        Job job = jobMapper.selectByPrimaryKey(jobId);

        return JobUtil.getJobVO(job);
    }

    public JobVO getJobByJobIdFromIndex(String jobId) {
        Map result = searchService.getJob(jobId);
        return JobUtil.getJobVO(result);
    }

    public List<JobVO> searchJobVOByJobType(int jobType) {


        return null;
    }




    @Override
    public List<JobVO> getRecommendFromUser(String userId,int page,String keyword) {
        System.out.println("userId = " + userId);
        Map properties = userClient.getUserInfo(userId);
        properties.forEach((key,value)->{
            System.out.println("key value = " + key +" "+ value);

        });
        String wantJobTypes = (String) properties.get("wantJob");
        String[] jobTypes = wantJobTypes.split(",");
        System.out.println("wantJobTypes = " + wantJobTypes);
        return searchJob(jobTypes,page,keyword);
    }

    private List<JobVO> searchJob(String[] jobTypes,int page,String keyword) {
        List<JobVO> jobList = new ArrayList();
        List<Map> list = searchService.searchJobByType(jobTypes,page);
        list.forEach(map->{
            jobList.add(JobUtil.getJobVO(map));
        });
    return jobList;
    }


}
