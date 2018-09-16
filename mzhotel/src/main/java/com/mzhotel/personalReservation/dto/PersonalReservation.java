package com.mzhotel.personalReservation.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PersonalReservation implements Serializable {
    private String id;

    private String area;

    private String roomCode;

    private String dinnerTimeCode;

    private String contactUser;

    private String remark;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    private static final long serialVersionUID = 1L;
}