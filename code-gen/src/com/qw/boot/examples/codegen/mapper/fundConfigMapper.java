package com.qw.boot.examples.codegen.mapper;

import com.qw.boot.examples.codegen.entity.fundConfig;

public interface fundConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(fundConfig record);

    int insertSelective(fundConfig record);

    fundConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(fundConfig record);

    int updateByPrimaryKey(fundConfig record);
}