package com.mzhotel.sm.login.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryUserInfo implements Serializable{

    private String userId;

    private String password;

    private String username;
}