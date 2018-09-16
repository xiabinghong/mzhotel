package com.mzhotel.login.service.impl;

import com.mzhotel.login.dto.QueryUserInfo;
import com.mzhotel.login.service.loginService;
import com.mzhotel.userInfo.dto.UserInfo;
import com.mzhotel.userInfo.mapper.UserInfoMapper;
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
    public UserInfo selectUserBylogin(QueryUserInfo queryUserInfo){
        return userInfoMapper.selectUserByLogin(queryUserInfo);
    }
}
