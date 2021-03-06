package com.mzhotel.sm.dinnerParty.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mzhotel.sm.actionLog.dto.ActionLogEnum;
import com.mzhotel.sm.actionLog.service.ActionLogService;
import com.mzhotel.sm.dinnerParty.dto.DinnerParty;
import com.mzhotel.sm.dinnerParty.dto.QueryDinnerParty;
import com.mzhotel.sm.dinnerParty.mapper.DinnerPartyMapper;
import com.mzhotel.sm.dinnerParty.service.DinnerPartyService;
import com.mzhotel.sm.documentInfoRelation.service.DocumentInfoRelationService;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DinnerPartyServiceImpl implements DinnerPartyService {

    @Autowired
    DinnerPartyMapper dinnerPartyMapper;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    ActionLogService actionLogService;

    @Autowired
    DocumentInfoRelationService documentInfoRelationService;

    @Override
    @Transactional
    public void delete(String id) {
        actionLogService.insert(id, ActionLogEnum.DELETE);
        if (StringUtils.isEmpty(id)) {
            return;
        }
        dinnerPartyMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public DinnerParty insert(DinnerParty record) {
        record.setCreatedBy(userInfoService.getCurrUser());
        record.setCreatedDate(new Date());
        int result = dinnerPartyMapper.insert(record);
        if (result == 1) {
            actionLogService.insert(record.getId(), ActionLogEnum.SAVE);
            return getOneDinnerParty(record.getId());
        }
        return null;
    }

    @Override
    @Transactional
    public DinnerParty update(DinnerParty record) {
        record.setUpdatedBy(userInfoService.getCurrUser());
        record.setUpdatedDate(new Date());
        int result = dinnerPartyMapper.updateByPrimaryKeySelective(record);
        if (result == 1) {
            actionLogService.insert(record.getId(), ActionLogEnum.UPDATE);
            return getOneDinnerParty(record.getId());
        }
        return null;
    }

    @Override
    public List<DinnerParty> getDinnerPartyList(QueryDinnerParty queryDinnerParty) {
        return dinnerPartyMapper.getDinnerParty(queryDinnerParty);
    }

    @Override
    public PageResult<DinnerParty> getDinnerParty(QueryDinnerParty queryDinnerParty) {
        PageHelper.startPage(queryDinnerParty.getPageNum(), queryDinnerParty.getPageSize());
        List<DinnerParty> dinnerPartyList = getDinnerPartyList(queryDinnerParty);
        return new PageResult<DinnerParty>((Page<DinnerParty>) dinnerPartyList);
    }

    @Override
    public DinnerParty getOneDinnerParty(String id) {
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        return dinnerPartyMapper.selectByPrimaryKey(id);
    }


}
