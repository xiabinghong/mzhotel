package com.mzhotel.sm.role.service.impl;

import com.mzhotel.sm.documentInfoRelation.service.DocumentInfoRelationService;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.role.dto.Role;
import com.mzhotel.sm.role.mapper.RoleMapper;
import com.mzhotel.sm.role.service.RoleService;
import com.mzhotel.sm.role.dto.QueryRole;
import com.mzhotel.sm.role.dto.Role;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import com.mzhotel.sm.util.MyBatisDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    MyBatisDAO<Role> myBatisDAO;

    @Autowired
    DocumentInfoRelationService documentInfoRelationService;

    private static final String mapper = "RoleMapper";

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id){
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Role getOneRole(String id) {
        if (id == null) {
            return null;
        }
        return roleMapper.selectByPrimaryKey(id);
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
    public int updateByPrimaryKey(Role record) {
        return  roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Role> getRoleList(QueryRole queryRole) {
        return roleMapper.getRole(queryRole);
    }

    @Override
    public PageResult<Role> getRole(QueryRole queryRole) {
        List<Role> roleList = getRoleList(queryRole);
        return myBatisDAO.queryPage(roleList,queryRole.getPageNum(), queryRole.getPageSize());
    }
}
