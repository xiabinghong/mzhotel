package com.mzhotel.sm.personalReservation.service;

import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.personalReservation.dto.PersonalReservation;
import com.mzhotel.sm.personalReservation.dto.QueryPersonalReservation;

import java.util.List;

public interface PersonalReservationService {

    int delete(String id);

    PersonalReservation insert(PersonalReservation record);

    PersonalReservation update(PersonalReservation record);

    List<PersonalReservation> getPersonalReservationList(QueryPersonalReservation queryPersonalReservation);

    PageResult<PersonalReservation> getPersonalReservation(QueryPersonalReservation queryPersonalReservation);

    PersonalReservation getOnePersonalReservation(String id);
}
