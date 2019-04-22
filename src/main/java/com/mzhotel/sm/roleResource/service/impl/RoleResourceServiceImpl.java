package com.mzhotel.sm.roleResource.service.impl;

import com.mzhotel.sm.resource.dto.Resource;
import com.mzhotel.sm.roleResource.dto.QueryRoleResource;
import com.mzhotel.sm.roleResource.dto.RoleResourceRelation;
import com.mzhotel.sm.roleResource.mapper.RoleResourceRelationMapper;
import com.mzhotel.sm.roleResource.service.RoleResourceService;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RoleResourceServiceImpl implements RoleResourceService {

    @Autowired
    RoleResourceRelationMapper roleResourceRelationMapper;

    @Autowired
    UserInfoService userInfoService;

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

    @Override
    public RoleResourceRelation getRoleResource(QueryRoleResource queryRoleResource) {
        String roleCode = queryRoleResource.getRoleCode();
        if (roleCode == null) {
            return null;
        }
        RoleResourceRelation roleResourceRelation = new RoleResourceRelation();
        if ("ROLE_HAS_RESOURCE".equals(queryRoleResource.getQueryType()) || "ALL".equals(queryRoleResource.getQueryType())) {
            queryRoleResource.setNotHasResource(null);
            queryRoleResource.setHasResource(roleCode);
            List<Resource> hasReourceList = roleResourceRelationMapper.getRoleHasResource(queryRoleResource);
            roleResourceRelation.setHasResourceList(hasReourceList);
        }
        if ("ROLE_NOT_HAS_RESOURCE".equals(queryRoleResource.getQueryType()) || "ALL".equals(queryRoleResource.getQueryType())) {
            queryRoleResource.setNotHasResource(roleCode);
            queryRoleResource.setHasResource(null);
            List<Resource> notHasReourceList = roleResourceRelationMapper.getRoleHasResource(queryRoleResource);
            roleResourceRelation.setNotHasResourceList(notHasReourceList);
        }
        if (roleResourceRelation == null) {
            return null;
        }
        return roleResourceRelation;
    }

    @Override
    @Transactional
    public void addRoleResource(String roleCode, String resourceCode, String action) {
        if (roleCode == null || resourceCode == null || action == null) {
            return;
        }
        RoleResourceRelation roleResourceRelation = new RoleResourceRelation();
        roleResourceRelation.setAction(action);
        roleResourceRelation.setRoleCode(roleCode);
        roleResourceRelation.setResourceCode(resourceCode);
        roleResourceRelation.setCreatedBy(userInfoService.getCurrUser());
        roleResourceRelation.setCreatedDate(new Date());
        roleResourceRelation.setUpdatedBy(userInfoService.getCurrUser());
        roleResourceRelation.setUpdatedDate(new Date());
        roleResourceRelationMapper.insertSelective(roleResourceRelation);
    }

    @Override
    @Transactional
    public void removeRoleResource(String roleCode, String resourceCode, String action) {
        if (roleCode == null || resourceCode == null) {
            return;
        }
        roleResourceRelationMapper.removeRoleResource(roleCode, resourceCode, action);
    }

}
