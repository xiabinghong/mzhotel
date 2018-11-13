package com.mzhotel.sm.actionLog.dto;

import com.mzhotel.sm.pageUtil.BaseQueryModel;
import lombok.Data;

@Data
public class QueryActionLog extends BaseQueryModel {

    private String actionType;

    private String parentId;

}
