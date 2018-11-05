package com.mzhotel.sm.personalReservation.dto;

import com.mzhotel.sm.pageUtil.BaseQueryModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryPersonalReservation extends BaseQueryModel implements Serializable {

    private String id;

    private String area;

    private String roomCode;

    private String dinnerTimeCode;

    private String contactUser;
}
