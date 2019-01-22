package com.mzhotel.sm.userInfo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfo implements Serializable {

    private String id;

    private String userId;

    private String username;

    private String password;

    private String tel;

    private String address;

    private String state;

    private String remark;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

}