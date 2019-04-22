package com.mzhotel.sm.userRole.mapper;

import com.mzhotel.sm.role.dto.Role;
import com.mzhotel.sm.userRole.dto.QueryUserRoleRelation;
import com.mzhotel.sm.userRole.dto.UserRoleRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserRoleRelation record);

    int insertSelective(UserRoleRelation record);

    UserRoleRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRoleRelation record);

    int updateByPrimaryKey(UserRoleRelation record);

    List<Role> getUserRoleRelation(QueryUserRoleRelation queryUserRoleRelation);

    void deleteByUserRoleCode(@Param(value="userId") String userId,@Param(value="roleCode") String roleCode);
}