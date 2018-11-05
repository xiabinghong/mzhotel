package com.mzhotel.sm.userInfo.mapper;

import com.mzhotel.sm.login.dto.QueryUserInfo;
import com.mzhotel.sm.role.dto.Role;
import com.mzhotel.sm.userInfo.dto.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo selectUserByLogin(QueryUserInfo queryUserInfo);

    UserInfo getUserInfoByUserName(QueryUserInfo queryUserInfo);

    List<Role> getRoleInfo(QueryUserInfo queryUserInfo);

    List<UserInfo> getUserInfo(QueryUserInfo queryUserInfo);
}