package com.mzhotel.roleResource.service;

import com.mzhotel.roleResource.dto.RoleResourceRelation;

public interface RoleResourceService {

    int deleteByPrimaryKey(String id);

    int insert(RoleResourceRelation record);

    int insertSelective(RoleResourceRelation record);

    RoleResourceRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleResourceRelation record);

    int updateByPrimaryKey(RoleResourceRelation record);
}
