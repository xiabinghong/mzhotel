package com.mzhotel.sm.role.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Role implements Serializable {
    private String id;

    private String roleName;

    private String roleCode;

    private String roleType;

    private String roleParent;

    private String state;

    private Long orderNo;

    private String remark;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;
}