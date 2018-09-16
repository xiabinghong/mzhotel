package com.mzhotel.dinnerParty.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DinnerParty implements Serializable {
    private String id;

    private String dinnerPartyType;

    private String dinnerPartyUser;

    private String tel;

    private String consumptionItem;

    private String remark;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    private static final long serialVersionUID = 1L;
}