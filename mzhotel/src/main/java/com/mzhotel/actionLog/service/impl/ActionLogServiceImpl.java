package com.mzhotel.actionLog.service.impl;

import com.mzhotel.actionLog.dto.ActionLog;
import com.mzhotel.actionLog.mapper.ActionLogMapper;
import com.mzhotel.actionLog.service.ActionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActionLogServiceImpl implements ActionLogService{

    @Autowired
    ActionLogMapper actionLogMapper;

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id){
        return actionLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insert(ActionLog record){
        return actionLogMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(ActionLog record){
        return actionLogMapper.insertSelective(record);
    }

    @Override
    public ActionLog selectByPrimaryKey(String id){
        return actionLogMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(ActionLog record){
        return actionLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(ActionLog record){
        return actionLogMapper.updateByPrimaryKey(record);
    }
}
