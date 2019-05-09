package com.dixn.dxboot.mybatis.mapper;


import com.dixn.dxboot.mybatis.model.TeFcs;

public interface TeFcsMapper {
    int deleteByPrimaryKey(String id);

    int insert(TeFcs record);

    int insertSelective(TeFcs record);

    TeFcs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TeFcs record);

    int updateByPrimaryKey(TeFcs record);
}