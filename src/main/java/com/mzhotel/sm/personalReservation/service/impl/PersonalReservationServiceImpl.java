package com.mzhotel.sm.personalReservation.service.impl;

import com.mzhotel.sm.documentInfoRelation.dto.DocumentInfoRelation;
import com.mzhotel.sm.documentInfoRelation.service.DocumentInfoRelationService;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.personalReservation.dto.QueryPersonalReservation;
import com.mzhotel.sm.personalReservation.dto.PersonalReservation;
import com.mzhotel.sm.personalReservation.mapper.PersonalReservationMapper;
import com.mzhotel.sm.personalReservation.service.PersonalReservationService;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import com.mzhotel.sm.util.MyBatisDAO;
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
    MyBatisDAO<PersonalReservation> myBatisDAO;

    @Autowired
    DocumentInfoRelationService documentInfoRelationService;

    private static final String mapper = "PersonalReservationMapper";

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id) {
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
            return getOnePersonalReservation(record.getId());
        }
        return null;
    }

    @Override
    @Transactional
    public int insertSelective(PersonalReservation record) {
        return personalReservationMapper.insertSelective(record);
    }

    @Override
    public PersonalReservation selectByPrimaryKey(String id) {
        return personalReservationMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(PersonalReservation record) {
        return personalReservationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public PersonalReservation updateByPrimaryKey(PersonalReservation record) {
        Assert.notNull(record,"更新对象不能为空!");
        Assert.isTrue(StringUtils.trimToNull(record.getId()) != null,"更新对象主键不能为空!");
        personalReservationMapper.updateByPrimaryKey(record);
        return getOnePersonalReservation(record.getId());
    }

    @Override
    public List<PersonalReservation> getPersonalReservationList(QueryPersonalReservation queryPersonalReservation) {
        return personalReservationMapper.getPersonalReservation(queryPersonalReservation);
    }

    @Override
    public PageResult<PersonalReservation> getPersonalReservation(QueryPersonalReservation queryPersonalReservation) {
        List<PersonalReservation> personalReservationList = getPersonalReservationList(queryPersonalReservation);
        return myBatisDAO.queryPage(personalReservationList,queryPersonalReservation.getPageNum(), queryPersonalReservation.getPageSize());
    }
}
