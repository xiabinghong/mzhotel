package com.mzhotel.actionLog.service;

import com.mzhotel.actionLog.dto.ActionLog;

public interface ActionLogService {

    int deleteByPrimaryKey(String id);

    int insert(ActionLog record);

    int insertSelective(ActionLog record);

    ActionLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActionLog record);

    int updateByPrimaryKey(ActionLog record);
}
