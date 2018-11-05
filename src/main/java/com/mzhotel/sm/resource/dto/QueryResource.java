package com.mzhotel.sm.resource.dto;

import com.mzhotel.sm.pageUtil.BaseQueryModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryResource extends BaseQueryModel implements Serializable {

    private String id;

    private String resourceName;

    private String resourceType;
}
