package com.mzhotel.sm.userRole.service;

import com.mzhotel.sm.userRole.dto.QueryUserRoleRelation;
import com.mzhotel.sm.userRole.dto.UserRoleRelation;

public interface UserRoleService {

    void delete(String id);

    UserRoleRelation insert(UserRoleRelation record);

    UserRoleRelation selectOne(String id);

    UserRoleRelation update(UserRoleRelation record);

    UserRoleRelation getUserRoleRelation(QueryUserRoleRelation queryUserRoleRelation);

    void addUserRole(String roleCode,String userId);

    void removeUserRole(String roleCode,String userId);
}
