package com.dagong.mapper;

import com.dagong.pojo.Company;

public interface CompanyMapper {
    int deleteByPrimaryKey(String id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(String id);

    Company selectByName(String name);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);
}