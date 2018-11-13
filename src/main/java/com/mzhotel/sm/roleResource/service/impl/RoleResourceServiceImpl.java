package com.mzhotel.sm.roleResource.service.impl;

import com.mzhotel.sm.roleResource.dto.RoleResourceRelation;
import com.mzhotel.sm.roleResource.mapper.RoleResourceRelationMapper;
import com.mzhotel.sm.roleResource.service.RoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleResourceServiceImpl implements RoleResourceService {

    @Autowired
    RoleResourceRelationMapper roleResourceRelationMapper;

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id) {
        return roleResourceRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insert(RoleResourceRelation record) {
        return roleResourceRelationMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(RoleResourceRelation record) {
        return roleResourceRelationMapper.insertSelective(record);
    }

    @Override
    public RoleResourceRelation selectByPrimaryKey(String id) {
        return roleResourceRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(RoleResourceRelation record) {
        return roleResourceRelationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(RoleResourceRelation record) {
        return roleResourceRelationMapper.updateByPrimaryKey(record);
    }
}
