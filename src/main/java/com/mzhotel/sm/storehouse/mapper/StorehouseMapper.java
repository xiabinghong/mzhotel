package com.mzhotel.sm.storehouse.mapper;

import com.mzhotel.sm.storehouse.dto.QueryStorehouse;
import com.mzhotel.sm.storehouse.dto.Storehouse;

import java.util.List;

public interface StorehouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(Storehouse record);

    int insertSelective(Storehouse record);

    Storehouse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Storehouse record);

    int updateByPrimaryKey(Storehouse record);

    List<Storehouse> getStorehouse(QueryStorehouse queryStorehouse);
    
    
}