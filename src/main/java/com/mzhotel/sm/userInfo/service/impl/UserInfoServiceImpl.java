package com.mzhotel.sm.userInfo.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mzhotel.sm.actionLog.dto.ActionLogEnum;
import com.mzhotel.sm.actionLog.service.ActionLogService;
import com.mzhotel.sm.common.ContextHolderUtils;
import com.mzhotel.sm.login.dto.QueryUserInfo;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.role.dto.Role;
import com.mzhotel.sm.userInfo.dto.UserInfo;
import com.mzhotel.sm.userInfo.mapper.UserInfoMapper;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    ActionLogService actionLogService;

    public String getCurrUser() {
        HttpSession session = ContextHolderUtils.getSession();
        return (String) session.getAttribute("userId");
    }

    @Override
    public UserInfo getUserInfoByUserName(QueryUserInfo queryUserInfo) {
        return userInfoMapper.getUserInfoByUserName(queryUserInfo);
    }

    @Override
    public List<Role> getRoleInfo(QueryUserInfo queryUserInfo) {
        return userInfoMapper.getRoleInfo(queryUserInfo);
    }

    @Override
    public List<UserInfo> getUserInfo(QueryUserInfo queryUserInfo) {
        return userInfoMapper.getUserInfo(queryUserInfo);
    }

    @Override
    public PageResult<UserInfo> queryPage(QueryUserInfo queryUserInfo) {
        PageHelper.startPage(queryUserInfo.getPageNum(), queryUserInfo.getPageSize());
        List<UserInfo> userInfoList = getUserInfo(queryUserInfo);
        return new PageResult<UserInfo>((Page<UserInfo>) userInfoList);
    }

    @Transactional
    @Override
    public void delete(String id) {
        actionLogService.insert(id, ActionLogEnum.DELETE);
        if (StringUtils.isEmpty(id)) {
            return;
        }
        userInfoMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public UserInfo insert(UserInfo record) {
        record.setCreatedBy(getCurrUser());
        record.setCreatedDate(new Date());
        int result = userInfoMapper.insert(record);
        if (result == 1) {
            actionLogService.insert(record.getId(), ActionLogEnum.SAVE);
            return selectOne(record.getId());
        }
        return null;
    }

    @Override
    public UserInfo selectOne(String id) {
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public UserInfo update(UserInfo record) {
        record.setUpdatedBy(getCurrUser());
        record.setUpdatedDate(new Date());
        int result = userInfoMapper.updateByPrimaryKeySelective(record);
        if (result == 1) {
            actionLogService.insert(record.getId(), ActionLogEnum.UPDATE);
            return selectOne(record.getId());
        }
        return null;
    }
}
