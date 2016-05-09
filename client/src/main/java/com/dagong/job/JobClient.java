package com.dagong.job;

import com.dagong.job.vo.JobVO;

import java.util.List;

/**
 * Created by liuchang on 16/4/24.
 */
public interface JobClient {
    JobVO getJobByJobId(String jobId);
    List<JobVO> getRecommendFromUser(String userId,int page,String keyword);
}
