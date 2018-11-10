package com.mzhotel.sm.userInfo.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.mzhotel.sm.common.ContextHolderUtils;
import com.mzhotel.sm.login.dto.QueryUserInfo;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.role.dto.Role;
import com.mzhotel.sm.userInfo.dto.UserInfo;
import com.mzhotel.sm.userInfo.mapper.UserInfoMapper;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import com.mzhotel.sm.util.MyBatisDAO;
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
    MyBatisDAO<UserInfo> myBatisDAO;

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
        return myBatisDAO.selectPage(getUserInfo(queryUserInfo), queryUserInfo.getPageNum(), queryUserInfo.getPageSize());
    }

    @Transactional
    @Override
    public void delete(String id) {
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
            return selectOne(record.getId());
        }
        return null;
    }
}
