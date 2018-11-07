package com.mzhotel.sm.userInfo.service.impl;

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
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    MyBatisDAO<UserInfo> myBatisDAO;

    public String getCurrUser() {
        HttpSession session = ContextHolderUtils.getSession();
        return (String)session.getAttribute("userId");
    }

    @Override
    public UserInfo getUserInfoByUserName(QueryUserInfo queryUserInfo){
        return userInfoMapper.getUserInfoByUserName(queryUserInfo);
    }

    @Override
    public List<Role> getRoleInfo(QueryUserInfo queryUserInfo){
        return userInfoMapper.getRoleInfo(queryUserInfo);
    }

    @Override
    public List<UserInfo> getUserInfo(QueryUserInfo queryUserInfo){
        return userInfoMapper.getUserInfo(queryUserInfo);
    }

    @Override
    public PageResult<UserInfo> queryPage(QueryUserInfo queryUserInfo){
        return myBatisDAO.selectPage(getUserInfo(queryUserInfo),queryUserInfo.getPageNum(),queryUserInfo.getPageSize());
    }

    @Transactional
    @Override
    public int deleteByPrimaryKey(String id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int insert(UserInfo record) {
        record.setCreatedBy(getCurrUser());
        record.setCreatedDate(new Date());
        return userInfoMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }

    @Override
    public UserInfo selectByPrimaryKey(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }
}
