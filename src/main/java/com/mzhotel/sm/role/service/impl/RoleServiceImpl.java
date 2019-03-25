package com.mzhotel.sm.role.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mzhotel.sm.actionLog.dto.ActionLogEnum;
import com.mzhotel.sm.actionLog.service.ActionLogService;
import com.mzhotel.sm.documentInfoRelation.service.DocumentInfoRelationService;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.role.dto.QueryRole;
import com.mzhotel.sm.role.dto.Role;
import com.mzhotel.sm.role.mapper.RoleMapper;
import com.mzhotel.sm.role.service.RoleService;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserInfoService userInfoService;

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
        PageHelper.startPage(queryRole.getPageNum(), queryRole.getPageSize());
        List<Role> roleList = getRoleList(queryRole);
        return new PageResult<Role>((Page<Role>) roleList);
    }
}
