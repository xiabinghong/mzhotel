package com.mzhotel.storehouse.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mzhotel.pageUtil.PageBean;
import com.mzhotel.storehouse.dto.QueryStorehouse;
import com.mzhotel.storehouse.dto.Storehouse;
import com.mzhotel.storehouse.mapper.StorehouseMapper;
import com.mzhotel.storehouse.service.StorehouseService;
import com.mzhotel.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class StorehouseServiceImpl implements StorehouseService {

    @Autowired
    StorehouseMapper storehouseMapper;

    @Autowired
    UserInfoService userInfoService;

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id) {
        return storehouseMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insert(Storehouse record) {
        record.setCreatedDate(new Date());
        record.setCreatedBy(userInfoService.getCurrUser());
        return storehouseMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(Storehouse record) {
        return storehouseMapper.insertSelective(record);
    }

    @Override
    public Storehouse selectByPrimaryKey(String id) {
        return storehouseMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(Storehouse record) {
        return storehouseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(Storehouse record) {
        return storehouseMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Storehouse> getStorehouseList(QueryStorehouse queryStorehouse) {
        return storehouseMapper.getStroehouse(queryStorehouse);
    }

    @Override
    public PageBean<Storehouse> getStorehouse(QueryStorehouse queryStorehouse) {
        PageHelper.startPage(queryStorehouse.getPageNum(), queryStorehouse.getPageSize());
        return new PageBean<Storehouse>(getStorehouseList(queryStorehouse));
    }
}
