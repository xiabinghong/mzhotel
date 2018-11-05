package com.mzhotel.sm.actionLog.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ActionLog implements Serializable {
    private String id;

    private String parentId;

    private BigDecimal amount;

    private Date actionDate;

    private String actionType;

    private String applyUser;

    private String auditUser;

    private String handleUser;

    private String remark;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    private BigDecimal storeSumAmount;

    private static final long serialVersionUID = 1L;
}