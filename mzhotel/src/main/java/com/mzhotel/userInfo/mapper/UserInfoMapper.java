package com.mzhotel.userInfo.mapper;

import com.mzhotel.login.dto.QueryUserInfo;
import com.mzhotel.userInfo.dto.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    UserInfo selectUserByLogin(QueryUserInfo queryUserInfo);
}