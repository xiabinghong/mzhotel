package com.mzhotel.sm.role.service.impl;

import com.mzhotel.sm.actionLog.dto.ActionLogEnum;
import com.mzhotel.sm.actionLog.service.ActionLogService;
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

import java.util.Date;
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
    ActionLogService actionLogService;

    @Autowired
    DocumentInfoRelationService documentInfoRelationService;

    private static final String mapper = "RoleMapper";

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Role getOneRole(String id) {
        actionLogService.insert(id, ActionLogEnum.DELETE);
        if (id == null) {
            return null;
        }
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Role insert(Role record) {
        record.setUpdatedBy(userInfoService.getCurrUser());
        record.setUpdatedDate(new Date());
        int result = roleMapper.insert(record);
        if (result == 1) {
            actionLogService.insert(record.getId(), ActionLogEnum.SAVE);
            return getOneRole(record.getId());
        }
        return null;
    }

    @Override
    @Transactional
    public Role update(Role record) {
        record.setUpdatedDate(new Date());
        record.setUpdatedBy(userInfoService.getCurrUser());
        int result = roleMapper.updateByPrimaryKeySelective(record);
        if (result == 1) {
            actionLogService.insert(record.getId(), ActionLogEnum.UPDATE);
            return getOneRole(record.getId());
        }
        return null;
    }

    @Override
    public List<Role> getRoleList(QueryRole queryRole) {
        return roleMapper.getRole(queryRole);
    }

    @Override
    public PageResult<Role> getRole(QueryRole queryRole) {
        List<Role> roleList = getRoleList(queryRole);
        return myBatisDAO.queryPage(roleList, queryRole.getPageNum(), queryRole.getPageSize());
    }
}
