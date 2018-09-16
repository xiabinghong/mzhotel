package com.mzhotel.storehouse.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Storehouse implements Serializable {
    private String id;

    private String area;

    private String room;

    private String goodsType;

    private String goodsName;

    private BigDecimal amount;

    private String state;

    private String remark;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    private static final long serialVersionUID = 1L;
}