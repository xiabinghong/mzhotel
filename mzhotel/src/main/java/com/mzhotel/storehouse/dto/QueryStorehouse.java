package com.mzhotel.storehouse.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryStorehouse implements Serializable {
    private Integer pageNum;

    private Integer pageSize;

    private String goodsType;

    private String goodsName;
}
