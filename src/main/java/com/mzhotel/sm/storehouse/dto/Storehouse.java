package com.mzhotel.sm.storehouse.dto;

import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Storehouse implements Serializable {
    private String id;

    @Excel(name = "区域", width = 20)
    private String area;

    @Excel(name = "房间", width = 20)
    private String room;

    @Excel(name = "物品类型", width = 20)
    private String goodsType;

    @Excel(name = "物品名称", width = 20)
    private String goodsName;

    @Excel(name = "数量", width = 20)
    private BigDecimal amount;

    @Excel(name = "单位", width = 20)
    private String unit;

    private String state;

    private String remark;

    private String createdBy;

    @Excel(name = "创建时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    @Excel(name = "创建人", width = 20)
    private String createdName;

    private String updatedName;

    private String documentInfoId;

    private String saveName;

    private static final long serialVersionUID = 1L;
}