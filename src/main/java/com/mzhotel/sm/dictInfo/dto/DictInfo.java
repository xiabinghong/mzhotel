package com.mzhotel.sm.dictInfo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DictInfo implements Serializable {
    private String id;

    private String parentId;

    private String dictTypeCode;

    private String dictTypeName;

    private String dictCode;

    private String dictName;

    private Long orderNo;

    private String state;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;
}