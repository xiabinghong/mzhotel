package com.mzhotel.sm.actionLog.service;

import com.mzhotel.sm.actionLog.dto.ActionLog;
import com.mzhotel.sm.actionLog.dto.QueryActionLog;

import java.util.List;

public interface ActionLogService {

    int deleteByPrimaryKey(String id);

    int insert(ActionLog record);

    int insertSelective(ActionLog record);

    ActionLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActionLog record);

    int updateByPrimaryKey(ActionLog record);

    List<ActionLog> queryActionLog(QueryActionLog queryActionLog);
}
