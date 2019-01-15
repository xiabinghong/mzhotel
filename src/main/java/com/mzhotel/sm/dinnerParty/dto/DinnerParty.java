package com.mzhotel.sm.dinnerParty.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DinnerParty implements Serializable {
    private String id;

    private Date startDate;

    private Date endDate;

    private String dinnerType;

    private String linkUser;

    private String tel;

    private String dinnerProject;

    private String remark;

    private String isSendMessage;

    private String state;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    private static final long serialVersionUID = 1L;
}