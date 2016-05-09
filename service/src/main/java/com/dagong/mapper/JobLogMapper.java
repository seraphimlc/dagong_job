package com.dagong.mapper;

import com.dagong.pojo.JobLog;

public interface JobLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(JobLog record);

    int insertSelective(JobLog record);

    JobLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(JobLog record);

    int updateByPrimaryKey(JobLog record);
}