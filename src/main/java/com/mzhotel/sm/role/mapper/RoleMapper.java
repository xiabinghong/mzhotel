package com.mzhotel.sm.role.mapper;

import com.mzhotel.sm.role.dto.QueryRole;
import com.mzhotel.sm.role.dto.Role;


import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> getRole(QueryRole queryRole);
}