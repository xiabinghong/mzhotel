package com.mzhotel.sm.resource.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Resource implements Serializable {
    private String id;

    private String resourceName;

    private String resourceCode;

    private String resourceType;

    private String url;

    private String resourceParent;

    private String state;

    private Long orderNo;

    private String remark;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;
}