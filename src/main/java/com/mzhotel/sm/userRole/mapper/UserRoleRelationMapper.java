package com.mzhotel.sm.userRole.mapper;

import com.mzhotel.sm.userRole.dto.UserRoleRelation;

public interface UserRoleRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserRoleRelation record);

    int insertSelective(UserRoleRelation record);

    UserRoleRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRoleRelation record);

    int updateByPrimaryKey(UserRoleRelation record);
}