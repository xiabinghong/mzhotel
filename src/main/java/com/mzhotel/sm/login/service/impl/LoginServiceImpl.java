package com.mzhotel.sm.login.service.impl;

import com.mzhotel.sm.login.dto.QueryUserInfo;
import com.mzhotel.sm.login.service.loginService;
import com.mzhotel.sm.userInfo.dto.UserInfo;
import com.mzhotel.sm.userInfo.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements loginService {

    @Autowired
    UserInfoMapper userInfoMapper;

   /* @Override
    public List<LoginDTO> getResource() {
        return loginMapper.getResource();
    }

    @Override
    public int insert(LoginDTO record) {
        //record.setCreatedTime(myBatisDAO.getCurrmentDate());
        return loginMapper.insert(record);
    }

    @Override
    public int update(LoginDTO record) {
        return loginMapper.update(record);
    }

    @Override
    public void delete(String id) {
        loginMapper.delete(id);
    }*/

    @Override
    public UserInfo selectUserBylogin(QueryUserInfo queryUserInfo) {
        return userInfoMapper.selectUserByLogin(queryUserInfo);
    }

    @Override
    public boolean isSuccess(QueryUserInfo queryUserInfo) {
        UserInfo userInfo = selectUserBylogin(queryUserInfo);
        if (userInfo != null) {
            return true;
        }
        return false;
    }
}
