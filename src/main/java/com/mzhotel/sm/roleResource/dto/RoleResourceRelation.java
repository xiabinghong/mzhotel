package com.mzhotel.sm.roleResource.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class RoleResourceRelation implements Serializable {
    private String id;

    private String roleCode;

    private String resourceCode;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    private String action;

    private static final long serialVersionUID = 1L;
}