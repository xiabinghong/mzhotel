package com.mzhotel.login.service;

import com.mzhotel.login.dto.LoginDTO;
import com.mzhotel.login.dto.QueryUserInfo;
import com.mzhotel.userInfo.dto.UserInfo;

import java.util.List;

public interface loginService {

    /*List<LoginDTO> getResource();

    int insert(LoginDTO record);

    int update(LoginDTO record);

    void delete(String id);*/

    UserInfo selectUserBylogin(QueryUserInfo queryUserInfo);
}
