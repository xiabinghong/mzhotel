package com.mzhotel.sm.login.mapper;

import com.mzhotel.sm.login.dto.LoginDTO;
import com.mzhotel.sm.login.dto.QueryUserInfo;
import com.mzhotel.sm.userInfo.dto.UserInfo;

import java.util.List;

public interface LoginMapper {
    List<LoginDTO> getResource();

    int insert(LoginDTO record);

    int update(LoginDTO record);

    void delete(String id);

    UserInfo selectUserBylogin(QueryUserInfo queryUserInfo);
}
