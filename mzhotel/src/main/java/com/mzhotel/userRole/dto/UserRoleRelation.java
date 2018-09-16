package com.mzhotel.userRole.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserRoleRelation implements Serializable {
    private String id;

    private String roleCode;

    private String userId;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    private static final long serialVersionUID = 1L;
}