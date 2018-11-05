package com.mzhotel.sm.userRole.service.impl;

import com.mzhotel.sm.userRole.dto.UserRoleRelation;
import com.mzhotel.sm.userRole.mapper.UserRoleRelationMapper;
import com.mzhotel.sm.userRole.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRelationMapper userRoleRelationMapper;

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id){
        return userRoleRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insert(UserRoleRelation record){
        return userRoleRelationMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(UserRoleRelation record){
        return userRoleRelationMapper.insertSelective(record);
    }

    @Override
    public UserRoleRelation selectByPrimaryKey(String id){
        return userRoleRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(UserRoleRelation record){
        return userRoleRelationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(UserRoleRelation record){
        return userRoleRelationMapper.updateByPrimaryKey(record);
    }
}
