package com.mzhotel.sm.personalReservation.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mzhotel.sm.actionLog.dto.ActionLogEnum;
import com.mzhotel.sm.actionLog.service.ActionLogService;
import com.mzhotel.sm.documentInfoRelation.service.DocumentInfoRelationService;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.personalReservation.dto.QueryPersonalReservation;
import com.mzhotel.sm.personalReservation.dto.PersonalReservation;
import com.mzhotel.sm.personalReservation.mapper.PersonalReservationMapper;
import com.mzhotel.sm.personalReservation.service.PersonalReservationService;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service
public class PersonalReservationServiceImpl implements PersonalReservationService {

    @Autowired
    PersonalReservationMapper personalReservationMapper;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    DocumentInfoRelationService documentInfoRelationService;

    @Autowired
    ActionLogService actionLogService;

    private static final String mapper = "PersonalReservationMapper";

    @Override
    @Transactional
    public int delete(String id) {
        actionLogService.insert(id, ActionLogEnum.DELETE);
        return personalReservationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PersonalReservation getOnePersonalReservation(String id) {
        if (id == null) {
            return null;
        }
        return personalReservationMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public PersonalReservation insert(PersonalReservation record) {
        record.setCreatedDate(new Date());
        record.setCreatedBy(userInfoService.getCurrUser());
        int result = personalReservationMapper.insert(record);
        if (result == 1) {
            actionLogService.insert(record.getId(), ActionLogEnum.SAVE);
            return getOnePersonalReservation(record.getId());
        }
        return null;
    }

    @Override
    @Transactional
    public PersonalReservation update(PersonalReservation record) {
        Assert.notNull(record, "更新对象不能为空!");
        Assert.isTrue(StringUtils.trimToNull(record.getId()) != null, "更新对象主键不能为空!");
        int result = personalReservationMapper.updateByPrimaryKey(record);
        if (result == 1) {
            actionLogService.insert(record.getId(), ActionLogEnum.UPDATE);
            return getOnePersonalReservation(record.getId());
        }
        return null;
    }

    @Override
    public List<PersonalReservation> getPersonalReservationList(QueryPersonalReservation queryPersonalReservation) {
        return personalReservationMapper.getPersonalReservation(queryPersonalReservation);
    }

    @Override
    public PageResult<PersonalReservation> getPersonalReservation(QueryPersonalReservation queryPersonalReservation) {
        PageHelper.startPage(queryPersonalReservation.getPageNum(),queryPersonalReservation.getPageSize());
        List<PersonalReservation> personalReservationList = getPersonalReservationList(queryPersonalReservation);
        return new PageResult<PersonalReservation>((Page<PersonalReservation>) personalReservationList);
    }
}
