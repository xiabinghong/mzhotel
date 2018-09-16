package com.mzhotel.login.mapper;

import com.mzhotel.login.dto.LoginDTO;
import com.mzhotel.login.dto.QueryUserInfo;
import com.mzhotel.userInfo.dto.UserInfo;

import java.util.List;

public interface LoginMapper {
    List<LoginDTO> getResource();

    int insert(LoginDTO record);

    int update(LoginDTO record);

    void delete(String id);

    UserInfo selectUserBylogin(QueryUserInfo queryUserInfo);
}
