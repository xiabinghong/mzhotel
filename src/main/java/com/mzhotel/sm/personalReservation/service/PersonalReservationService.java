package com.mzhotel.sm.personalReservation.service;

import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.personalReservation.dto.PersonalReservation;
import com.mzhotel.sm.personalReservation.dto.QueryPersonalReservation;

import java.util.List;

public interface PersonalReservationService {

    int deleteByPrimaryKey(String id);

    PersonalReservation insert(PersonalReservation record);

    int insertSelective(PersonalReservation record);

    PersonalReservation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PersonalReservation record);

    PersonalReservation updateByPrimaryKey(PersonalReservation record);

    List<PersonalReservation> getPersonalReservationList(QueryPersonalReservation queryPersonalReservation);

    PageResult<PersonalReservation> getPersonalReservation(QueryPersonalReservation queryPersonalReservation);

    PersonalReservation getOnePersonalReservation(String id);
}
