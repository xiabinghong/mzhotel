package com.mzhotel.personalReservation.service;


import com.mzhotel.personalReservation.dto.PersonalReservation;

public interface PersonalReservationService {

    int deleteByPrimaryKey(String id);

    int insert(PersonalReservation record);

    int insertSelective(PersonalReservation record);

    PersonalReservation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PersonalReservation record);

    int updateByPrimaryKey(PersonalReservation record);
}
