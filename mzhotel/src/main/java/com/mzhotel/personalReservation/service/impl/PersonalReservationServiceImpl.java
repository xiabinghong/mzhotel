package com.mzhotel.personalReservation.service.impl;

import com.mzhotel.personalReservation.dto.PersonalReservation;
import com.mzhotel.personalReservation.mapper.PersonalReservationMapper;
import com.mzhotel.personalReservation.service.PersonalReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonalReservationServiceImpl implements PersonalReservationService {

    @Autowired
    PersonalReservationMapper personalReservationMapper;

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id){
        return personalReservationMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insert(PersonalReservation record){
        return personalReservationMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(PersonalReservation record){
        return personalReservationMapper.insertSelective(record);
    }

    @Override
    public PersonalReservation selectByPrimaryKey(String id){
        return personalReservationMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(PersonalReservation record){
        return personalReservationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(PersonalReservation record){
        return personalReservationMapper.updateByPrimaryKey(record);
    }
}
