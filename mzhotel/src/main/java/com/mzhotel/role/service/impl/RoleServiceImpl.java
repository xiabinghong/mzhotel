package com.mzhotel.role.service.impl;

import com.mzhotel.role.dto.Role;
import com.mzhotel.role.mapper.RoleMapper;
import com.mzhotel.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id){
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insert(Role record){
        return roleMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(Role record){
        return roleMapper.insertSelective(record);
    }

    @Override
    public Role selectByPrimaryKey(String id){
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(Role record){
        return roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(Role record){
        return roleMapper.updateByPrimaryKey(record);
    }
}
