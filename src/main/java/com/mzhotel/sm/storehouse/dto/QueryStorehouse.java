package com.mzhotel.sm.storehouse.dto;

import com.mzhotel.sm.pageUtil.BaseQueryModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryStorehouse extends BaseQueryModel implements Serializable {

    private String id;

    private String goodsType;

    private String goodsName;

    private String area;

    private String room;
}
