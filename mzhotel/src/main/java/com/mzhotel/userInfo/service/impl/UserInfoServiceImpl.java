package com.mzhotel.userInfo.service.impl;

import com.mzhotel.common.ContextHolderUtils;
import com.mzhotel.userInfo.dto.UserInfo;
import com.mzhotel.userInfo.mapper.UserInfoMapper;
import com.mzhotel.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    UserInfoMapper userInfoMapper;

    public String getCurrUser() {
        HttpSession session = ContextHolderUtils.getSession();
        return (String)session.getAttribute("userId");
    }

    @Transactional
    @Override
    public int deleteByPrimaryKey(String id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int insert(UserInfo record) {
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
