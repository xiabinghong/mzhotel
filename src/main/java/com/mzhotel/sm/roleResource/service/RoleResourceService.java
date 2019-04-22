package com.mzhotel.sm.roleResource.service;

import com.mzhotel.sm.roleResource.dto.QueryRoleResource;
import com.mzhotel.sm.roleResource.dto.RoleResourceRelation;

public interface RoleResourceService {

    int deleteByPrimaryKey(String id);

    int insert(RoleResourceRelation record);

    int insertSelective(RoleResourceRelation record);

    RoleResourceRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleResourceRelation record);

    int updateByPrimaryKey(RoleResourceRelation record);

    RoleResourceRelation getRoleResource(QueryRoleResource queryRoleResource);

    void addRoleResource(String roleCode, String resourceCode, String action);

    void removeRoleResource(String roleCode, String resourceCode, String action);
}
