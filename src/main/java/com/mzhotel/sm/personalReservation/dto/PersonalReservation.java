package com.mzhotel.sm.personalReservation.dto;

import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

@Data
public class PersonalReservation implements Serializable {
    private String id;

    @Excel(name = "区域", width = 20)
    private String area;

    @Excel(name = "房间", width = 20)
    private String roomCode;


    @Excel(name = "用餐时间", width = 20)
    private String dinnerTimeCode;


    @Excel(name = "联系人", width = 20)
    private String contactUser;


    @Excel(name = "联系电话", width = 20)
    private String tel;


    @Excel(name = "订台人", width = 20)
    private String manager;


    @Excel(name = "桌数", width = 20)
    private String tablenum;


    private String status;


    @Excel(name = "备注", width = 20)
    private String remark;


    @Excel(name = "操作人", width = 20)
    private String createdBy;

    @Excel(name = "创建时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    private String documentInfoId;

    private String saveName;
    private static final long serialVersionUID = 1L;


}