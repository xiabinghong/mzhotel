package com.mzhotel.sm.storehouse.service;

import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.storehouse.dto.QueryStorehouse;
import com.mzhotel.sm.storehouse.dto.Storehouse;

import java.util.List;

public interface StorehouseService {

    int deleteByPrimaryKey(String id);

    Storehouse insert(Storehouse record);

    int insertSelective(Storehouse record);

    Storehouse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Storehouse record);

    Storehouse updateByPrimaryKey(Storehouse record);

    List<Storehouse> getStorehouseList(QueryStorehouse queryStorehouse);

    PageResult<Storehouse> getStorehouse(QueryStorehouse queryStorehouse);

    Storehouse getOneStorehouse(String id);
}
