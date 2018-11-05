package com.mzhotel.sm.personalReservation.mapper;

import com.mzhotel.sm.personalReservation.dto.PersonalReservation;
import com.mzhotel.sm.personalReservation.dto.QueryPersonalReservation;

import java.util.List;

public interface PersonalReservationMapper {
    int deleteByPrimaryKey(String id);

    int insert(PersonalReservation record);

    int insertSelective(PersonalReservation record);

    PersonalReservation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PersonalReservation record);

    int updateByPrimaryKey(PersonalReservation record);

    List<PersonalReservation> getPersonalReservation(QueryPersonalReservation queryPersonalReservation);

}