package com.qw.boot.examples.codegen.mapper;

import com.qw.boot.examples.codegen.entity.fundEveryday;

public interface fundEverydayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(fundEveryday record);

    int insertSelective(fundEveryday record);

    fundEveryday selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(fundEveryday record);

    int updateByPrimaryKey(fundEveryday record);
}