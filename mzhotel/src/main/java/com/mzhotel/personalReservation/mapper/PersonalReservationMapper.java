package com.mzhotel.personalReservation.mapper;

import com.mzhotel.personalReservation.dto.PersonalReservation;

public interface PersonalReservationMapper {
    int deleteByPrimaryKey(String id);

    int insert(PersonalReservation record);

    int insertSelective(PersonalReservation record);

    PersonalReservation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PersonalReservation record);

    int updateByPrimaryKey(PersonalReservation record);
}