package com.mzhotel.sm.actionLog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mzhotel.sm.actionLog.dto.ActionLog;
import com.mzhotel.sm.actionLog.dto.ActionLogEnum;
import com.mzhotel.sm.actionLog.dto.QueryActionLog;
import com.mzhotel.sm.actionLog.mapper.ActionLogMapper;
import com.mzhotel.sm.actionLog.service.ActionLogService;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ActionLogServiceImpl implements ActionLogService {

    @Autowired
    ActionLogMapper actionLogMapper;

    @Autowired
    UserInfoService userInfoService;

    @Override
    public List<ActionLog> queryActionLogList(QueryActionLog queryActionLog) {
        return actionLogMapper.queryActionLog(queryActionLog);
    }

    @Override
    public PageResult<ActionLog> queryActionLog(QueryActionLog queryActionLog) {
        PageHelper.startPage(queryActionLog.getPageNum(), queryActionLog.getPageSize());
        List<ActionLog> actionLogList = queryActionLogList(queryActionLog);
        return new PageResult<ActionLog>((Page<ActionLog>) actionLogList);
    }

    @Override
    @Transactional
    public int insert(String parentId, ActionLogEnum actionLogEnum) {
        ActionLog record = new ActionLog();
        record.setParentId(parentId);
        record.setActionDate(new Date());
        record.setApplyUser(userInfoService.getCurrUser());
        record.setCreatedBy(userInfoService.getCurrUser());
        record.setActionType(actionLogEnum.getActionLogType());
        record.setCreatedDate(new Date());
        return actionLogMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertStoreLog(ActionLog record) {
        record.setActionDate(new Date());
        record.setApplyUser(userInfoService.getCurrUser());
        record.setCreatedBy(userInfoService.getCurrUser());
        record.setCreatedDate(new Date());
        return actionLogMapper.insert(record);
    }

}
