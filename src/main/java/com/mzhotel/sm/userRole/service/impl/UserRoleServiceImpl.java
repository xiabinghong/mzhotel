package com.mzhotel.sm.userRole.service.impl;

import com.mzhotel.sm.userInfo.service.UserInfoService;
import com.mzhotel.sm.userRole.dto.UserRoleRelation;
import com.mzhotel.sm.userRole.mapper.UserRoleRelationMapper;
import com.mzhotel.sm.userRole.service.UserRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRelationMapper userRoleRelationMapper;

    @Autowired
    UserInfoService userInfoService;

    @Override
    @Transactional
    public void delete(String id) {
        if (StringUtils.isEmpty(id)) {
            return;
        }
        userRoleRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public UserRoleRelation insert(UserRoleRelation record) {
        record.setCreatedBy(userInfoService.getCurrUser());
        record.setCreatedDate(new Date());
        int result = userRoleRelationMapper.insert(record);
        if (result == 1) {
            return selectOne(record.getId());
        }
        return null;
    }

    @Override
    public UserRoleRelation selectOne(String id) {
        return userRoleRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public UserRoleRelation update(UserRoleRelation record) {
        record.setUpdatedBy(userInfoService.getCurrUser());
        record.setUpdatedDate(new Date());
        int result = userRoleRelationMapper.updateByPrimaryKeySelective(record);
        if (result == 1) {
            return selectOne(record.getId());
        }
        return null;
    }
}
