package com.mzhotel.sm.role.dto;

import com.mzhotel.sm.pageUtil.BaseQueryModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryRole extends BaseQueryModel implements Serializable {

    private String id;

    private String roleName;

    private String roleType;
}
