package com.mzhotel.sm.role.service;

import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.role.dto.QueryRole;
import com.mzhotel.sm.role.dto.Role;

import java.util.List;

public interface RoleService {

    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getRoleList(QueryRole queryRole);

    PageResult<Role> getRole(QueryRole queryRole);

    Role getOneRole(String id);
}
