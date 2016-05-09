package com.dagong.job.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.dagong.job.JobClientForManager;
import com.dagong.job.vo.JobVO;
import com.dagong.mapper.JobMapper;
import com.dagong.pojo.Job;
import com.dagong.service.SearchService;
import com.dagong.user.UserClient;
import com.dagong.util.BeanValidator;
import com.dagong.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import org.apache.commons.beanutils.BeanUtils;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by liuchang on 16/5/8.
 */

@Service(version = "1.0.0")
public class JobClientForManagerImpl implements JobClientForManager {


    private boolean readSwitch = false;

    @Resource
    private SearchService searchService;
    @Resource
    private JobMapper jobMapper;

    @Reference(version = "1.0.0")
    private UserClient userClient;

    @Resource
    private JobClientImpl jobClient;

    @Resource
    private IdGenerator idGenerator;

    @Override
    public boolean createJob(JobVO jobVO) {
        if(jobVO==null){
            return false;
        }
        BeanValidator.validate(jobVO);
        Job job = new Job();
        try {
            job.setId(idGenerator.generate(Job.class.getSimpleName()));
            BeanUtils.copyProperties(job,jobVO);
            jobMapper.insertSelective(job);
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean searchJob(String companyId, String userId, int status, int page, int pageSize) {
        if(readSwitch){
            PageHelper.startPage(page,pageSize);

            //read from db
        }else{
            //read from index
        }
        return false;
    }

    @Override
    public boolean updateJob(JobVO jobVO) {
        return false;
    }

    @Override
    public boolean stopJob(String jobId, String userId, String companyId, String reason) {
        return false;
    }

    @Override
    public boolean startJob(String jobId, String userId, String companyId, long startTime, long endTime) {
        return false;
    }
}
