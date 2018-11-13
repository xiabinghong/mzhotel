package com.mzhotel.sm.actionLog.service;

import com.mzhotel.sm.actionLog.dto.ActionLog;
import com.mzhotel.sm.actionLog.dto.ActionLogEnum;
import com.mzhotel.sm.actionLog.dto.QueryActionLog;
import com.mzhotel.sm.pageUtil.PageResult;

import java.util.List;

public interface ActionLogService {

    int insert(String parentId, ActionLogEnum actionLogEnum);

    List<ActionLog> queryActionLogList(QueryActionLog queryActionLog);

    PageResult<ActionLog> queryActionLog(QueryActionLog queryActionLog);

    int insertStoreLog(ActionLog actionLog);
}
