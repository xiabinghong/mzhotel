package com.mzhotel.storehouse.service;

import com.github.pagehelper.Page;
import com.mzhotel.pageUtil.PageBean;
import com.mzhotel.storehouse.dto.QueryStorehouse;
import com.mzhotel.storehouse.dto.Storehouse;

import java.util.List;

public interface StorehouseService {

    int deleteByPrimaryKey(String id);

    int insert(Storehouse record);

    int insertSelective(Storehouse record);

    Storehouse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Storehouse record);

    int updateByPrimaryKey(Storehouse record);

    List<Storehouse> getStorehouseList(QueryStorehouse queryStorehouse);

    PageBean<Storehouse> getStorehouse(QueryStorehouse queryStorehouse);
}
