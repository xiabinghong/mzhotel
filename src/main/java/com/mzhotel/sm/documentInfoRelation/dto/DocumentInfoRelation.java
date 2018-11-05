package com.mzhotel.sm.documentInfoRelation.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DocumentInfoRelation implements Serializable {
    private String id;

    private String documentId;

    private String relationId;

    private String relationType;

    private String relationCode;

    private String remark;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    private static final long serialVersionUID = 1L;
}