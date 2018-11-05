package com.mzhotel.sm.roleResource.mapper;

import com.mzhotel.sm.roleResource.dto.RoleResourceRelation;

public interface RoleResourceRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleResourceRelation record);

    int insertSelective(RoleResourceRelation record);

    RoleResourceRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleResourceRelation record);

    int updateByPrimaryKey(RoleResourceRelation record);
}