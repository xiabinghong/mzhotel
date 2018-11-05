package com.mzhotel.sm.login.service;

import com.mzhotel.sm.login.dto.QueryUserInfo;
import com.mzhotel.sm.userInfo.dto.UserInfo;

public interface loginService {

    /*List<LoginDTO> getResource();

    int insert(LoginDTO record);

    int update(LoginDTO record);

    void delete(String id);*/

    UserInfo selectUserBylogin(QueryUserInfo queryUserInfo);

    boolean isSuccess(QueryUserInfo queryUserInfo);
}
