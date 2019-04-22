package com.mzhotel.sm.roleResource.mapper;

import com.mzhotel.sm.resource.dto.Resource;
import com.mzhotel.sm.roleResource.dto.QueryRoleResource;
import com.mzhotel.sm.roleResource.dto.RoleResourceRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleResourceRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(RoleResourceRelation record);

    int insertSelective(RoleResourceRelation record);

    RoleResourceRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleResourceRelation record);

    int updateByPrimaryKey(RoleResourceRelation record);

    List<Resource> getRoleHasResource(QueryRoleResource queryRoleResource);

    void removeRoleResource(@Param(value="roleCode") String roleCode,
                            @Param(value="resourceCode") String resourceCode,
                            @Param(value="action") String action);
}