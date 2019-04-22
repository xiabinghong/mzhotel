package com.mzhotel.sm.userRole.service.impl;

import com.mzhotel.sm.role.dto.Role;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import com.mzhotel.sm.userRole.dto.QueryUserRoleRelation;
import com.mzhotel.sm.userRole.dto.UserRoleRelation;
import com.mzhotel.sm.userRole.mapper.UserRoleRelationMapper;
import com.mzhotel.sm.userRole.service.UserRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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

    @Override
    public UserRoleRelation getUserRoleRelation(QueryUserRoleRelation queryUserRoleRelation) {
        String userId = queryUserRoleRelation.getUserId();
        if (userId == null) {
            return null;
        }
        UserRoleRelation userRoleRelation = new UserRoleRelation();
        if ("USER_HAS_ROLE".equals(queryUserRoleRelation.getQueryType()) || "ALL".equals(queryUserRoleRelation.getQueryType())) {
            queryUserRoleRelation.setUserNotHasRole(null);
            queryUserRoleRelation.setUserHasRole(userId);
            List<Role> userHasRole = userRoleRelationMapper.getUserRoleRelation(queryUserRoleRelation);
            userRoleRelation.setUserHasRoleList(userHasRole);
        }
        if ("USER_NOT_HAS_ROLE".equals(queryUserRoleRelation.getQueryType()) || "ALL".equals(queryUserRoleRelation.getQueryType())) {
            queryUserRoleRelation.setUserHasRole(null);
            queryUserRoleRelation.setUserNotHasRole(userId);
            List<Role> userNotHasRole = userRoleRelationMapper.getUserRoleRelation(queryUserRoleRelation);
            userRoleRelation.setUserNotHasRoleList(userNotHasRole);
        }
        if (userRoleRelation == null) {
            return null;
        }
        return userRoleRelation;
    }

    @Override
    public void addUserRole(String roleCode,String userId) {
        if (userId == null || roleCode == null) {
            return;
        }
        UserRoleRelation userRoleRelation = new UserRoleRelation();
        userRoleRelation.setRoleCode(roleCode);
        userRoleRelation.setUserId(userId);
        userRoleRelation.setCreatedBy(userId);
        userRoleRelation.setCreatedDate(new Date());
        userRoleRelation.setUpdatedBy(userId);
        userRoleRelation.setUpdatedDate(new Date());
        userRoleRelationMapper.insertSelective(userRoleRelation);
    }

    @Override
    public void removeUserRole(String roleCode,String userId) {
        if (userId == null || roleCode == null) {
            return;
        }
        userRoleRelationMapper.deleteByUserRoleCode(userId, roleCode);
    }
}
