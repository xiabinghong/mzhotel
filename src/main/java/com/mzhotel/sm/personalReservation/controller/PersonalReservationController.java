package com.mzhotel.sm.personalReservation.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.personalReservation.dto.QueryPersonalReservation;
import com.mzhotel.sm.personalReservation.dto.PersonalReservation;
import com.mzhotel.sm.personalReservation.service.PersonalReservationService;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import com.mzhotel.sm.util.poi.entity.MultipleSheetExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/personalReservation")
public class PersonalReservationController {

    @Autowired
    PersonalReservationService personalReservationService;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/getPersonalReservationList", method = RequestMethod.GET)
    public List<PersonalReservation> getPersonalReservationList(QueryPersonalReservation queryPersonalReservation) {
        userInfoService.getCurrUser();
        return personalReservationService.getPersonalReservationList(queryPersonalReservation);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageResult<PersonalReservation> getPersonalReservation(QueryPersonalReservation queryPersonalReservation) {
        return personalReservationService.getPersonalReservation(queryPersonalReservation);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable(value = "id") String id) {
        return personalReservationService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public PersonalReservation insert(@RequestBody @Valid PersonalReservation record) {
        return personalReservationService.insert(record);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PersonalReservation selectByPrimaryKey(@PathVariable(value = "id") String id) {
        return personalReservationService.getOnePersonalReservation(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public PersonalReservation update(@PathVariable(value = "id") String id,
                                      @RequestBody @Valid PersonalReservation record) {
        record.setId(id);
        return personalReservationService.update(record);
    }

}
