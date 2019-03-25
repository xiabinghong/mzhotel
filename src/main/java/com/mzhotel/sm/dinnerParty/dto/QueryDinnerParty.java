package com.mzhotel.sm.dinnerParty.dto;

import com.mzhotel.sm.pageUtil.BaseQueryModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryDinnerParty extends BaseQueryModel implements Serializable {

    private String id;

    private String dinnerType;

    private String linkUser;

    private String tel;

    private String dinnerProject;
}
