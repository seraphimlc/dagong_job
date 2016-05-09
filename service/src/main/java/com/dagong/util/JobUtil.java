package com.dagong.util;

import com.dagong.job.vo.JobVO;
import com.dagong.pojo.Job;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by liuchang on 16/5/8.
 */
public class JobUtil {
    public static JobVO getJobVO(Job job) {
        if (job == null) {
            return null;
        }
        JobVO jobVO = new JobVO();
        try {
            BeanUtils.copyProperties(job, jobVO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return jobVO;
    }

    public static JobVO getJobVO(Map jobMap) {
        if (jobMap == null || jobMap.isEmpty()) {
            return null;
        }
        JobVO jobVO = new JobVO();
        try {
            BeanUtils.populate(jobVO, jobMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return jobVO;
    }
}
