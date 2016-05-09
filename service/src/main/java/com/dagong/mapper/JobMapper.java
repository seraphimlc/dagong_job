package com.dagong.mapper;

import com.dagong.pojo.Job;

import java.util.List;

public interface JobMapper {
    int deleteByPrimaryKey(String id);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(String id);

    List listJob(Job job);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}