package com.mzhotel.sm.login.dto;

import com.mzhotel.sm.pageUtil.BaseQueryModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryUserInfo extends BaseQueryModel implements Serializable {

    private String userId;

    private String password;

    private String username;
}
