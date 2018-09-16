package com.mzhotel.documentInfo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DocumentInfo implements Serializable {
    private String id;

    private String name;

    private String url;

    private String saveName;

    private String remark;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    private static final long serialVersionUID = 1L;
}