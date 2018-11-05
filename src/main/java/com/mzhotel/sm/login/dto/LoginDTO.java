package com.mzhotel.sm.login.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LoginDTO implements Serializable {

    private String resourceId;

    private String resourceType;

    private String id;

    private String resourceName;

    private String orderNo;

    private Long disable;

    private String status;

    private String parentId;

    private String createdBy;

    private Date createdTime;

    private String updatedBy;

    private Date updateTime;
}
