package com.mzhotel.sm.actionLog.service.impl;

import com.mzhotel.sm.actionLog.dto.ActionLog;
import com.mzhotel.sm.actionLog.dto.QueryActionLog;
import com.mzhotel.sm.actionLog.mapper.ActionLogMapper;
import com.mzhotel.sm.actionLog.service.ActionLogService;
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
    public List<ActionLog> queryActionLog(QueryActionLog queryActionLog) {
        return actionLogMapper.queryActionLog(queryActionLog);
    }

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id) {
        return actionLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insert(ActionLog record) {
        record.setActionDate(new Date());
        record.setApplyUser(userInfoService.getCurrUser());
        record.setCreatedBy(userInfoService.getCurrUser());
        record.setCreatedDate(new Date());
        return actionLogMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(ActionLog record) {
        record.setActionDate(new Date());
        record.setApplyUser(userInfoService.getCurrUser());
        record.setCreatedBy(userInfoService.getCurrUser());
        record.setCreatedDate(new Date());
        return actionLogMapper.insertSelective(record);
    }

    @Override
    public ActionLog selectByPrimaryKey(String id) {
        return actionLogMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(ActionLog record) {
        return actionLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(ActionLog record) {
        return actionLogMapper.updateByPrimaryKey(record);
    }
}
