package com.dagong.job;

import com.dagong.job.vo.JobVO;

/**
 * Created by liuchang on 16/5/8.
 */
public interface JobClientForManager {
    boolean createJob(JobVO jobVO);
    boolean searchJob(String companyId,String userId,int status,int page,int pageSize);
    boolean updateJob(JobVO jobVO);
    boolean stopJob(String jobId,String userId,String companyId,String reason);
    boolean startJob(String jobId,String userId,String companyId,long startTime,long endTime);

}
