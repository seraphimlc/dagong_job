package com.dagong.mapper;

import com.dagong.pojo.JobType;

import java.util.List;

public interface JobTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobType record);

    int insertSelective(JobType record);

    List<JobType> selectAll();

    List<JobType> selectByParentId(Integer parentId);

    JobType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobType record);

    int updateByPrimaryKey(JobType record);
}