package com.mzhotel.sm.userInfo.service;

import com.mzhotel.sm.login.dto.QueryUserInfo;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.role.dto.Role;
import com.mzhotel.sm.userInfo.dto.UserInfo;

import java.util.List;

public interface UserInfoService {

    PageResult<UserInfo> queryPage(QueryUserInfo queryUserInfo);

    void delete(String id);

    UserInfo insert(UserInfo record);

    UserInfo selectOne(String id);

    UserInfo update(UserInfo record);

    String getCurrUser();

    public UserInfo getUserInfoByUserName(QueryUserInfo queryUserInfo);

    List<Role> getRoleInfo(QueryUserInfo queryUserInfo);

    List<UserInfo> getUserInfo(QueryUserInfo queryUserInfo);
}


