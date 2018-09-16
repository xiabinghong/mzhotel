package com.mzhotel.login.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryUserInfo implements Serializable{

    private String userId;

    private String password;
}
