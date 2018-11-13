package com.mzhotel.sm.storehouse.service.impl;

import com.mzhotel.sm.documentInfoRelation.dto.DocumentInfoRelation;
import com.mzhotel.sm.documentInfoRelation.service.DocumentInfoRelationService;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.storehouse.dto.QueryStorehouse;
import com.mzhotel.sm.storehouse.dto.Storehouse;
import com.mzhotel.sm.storehouse.mapper.StorehouseMapper;
import com.mzhotel.sm.storehouse.service.StorehouseService;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import com.mzhotel.sm.util.MyBatisDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service
public class StorehouseServiceImpl implements StorehouseService {

    @Autowired
    StorehouseMapper storehouseMapper;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    MyBatisDAO<Storehouse> myBatisDAO;

    @Autowired
    DocumentInfoRelationService documentInfoRelationService;

    private static final String mapper = "StorehouseMapper";

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id) {
        return storehouseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Storehouse getOneStorehouse(String id) {
        if (id == null) {
            return null;
        }
        return storehouseMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Storehouse insert(Storehouse record) {
        record.setCreatedDate(new Date());
        record.setCreatedBy(userInfoService.getCurrUser());
        int result = storehouseMapper.insert(record);
        if (result == 1) {
            if (record.getDocumentInfoId() != null) {
                DocumentInfoRelation documentInfoRelation = new DocumentInfoRelation();
                documentInfoRelation.setCreatedBy(userInfoService.getCurrUser());
                documentInfoRelation.setCreatedDate(new Date());
                documentInfoRelation.setDocumentId(record.getDocumentInfoId());
                documentInfoRelation.setRelationId(record.getId());
                documentInfoRelation.setRelationCode(record.getId());
                documentInfoRelation.setRelationType("STORE_HOUSE");
                documentInfoRelationService.insert(documentInfoRelation);
            }
            return getOneStorehouse(record.getId());
        }
        return null;
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
    public Storehouse updateByPrimaryKey(Storehouse record) {
        Assert.notNull(record, "更新对象不能为空!");
        Assert.isTrue(StringUtils.trimToNull(record.getId()) != null, "更新对象主键不能为空!");
        storehouseMapper.updateByPrimaryKeySelective(record);
        return getOneStorehouse(record.getId());
    }

    @Override
    public List<Storehouse> getStorehouseList(QueryStorehouse queryStorehouse) {
        return storehouseMapper.getStorehouse(queryStorehouse);
    }

    @Override
    public PageResult<Storehouse> getStorehouse(QueryStorehouse queryStorehouse) {
        List<Storehouse> storehouseList = getStorehouseList(queryStorehouse);
        return myBatisDAO.queryPage(storehouseList, queryStorehouse.getPageNum(), queryStorehouse.getPageSize());
    }
}
