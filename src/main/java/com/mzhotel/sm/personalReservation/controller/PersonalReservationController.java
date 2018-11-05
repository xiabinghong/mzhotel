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

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public ModelAndView exportData(QueryPersonalReservation queryPersonalReservation, ModelMap modelMap) {
        List<Map<String,Object>> list = Lists.newArrayList();
        List<PersonalReservation> personalReservationList = personalReservationService.getPersonalReservationList(queryPersonalReservation);
        Map<String,Object> params = Maps.newHashMap();
        ExportParams personalReservationparams = new ExportParams();
        personalReservationparams.setTitle("订台管理");
        personalReservationparams.setSheetName("订台管理");
        params.put("title",personalReservationparams);
        params.put("entity",PersonalReservation.class);
        params.put("data",personalReservationList);
        list.add(params);
        ExportParams exportParams = new ExportParams();
        exportParams.setType(ExcelType.HSSF);
        modelMap.put(MultipleSheetExcelConstants.FILE_NAME, "订台管理");
        modelMap.put(MultipleSheetExcelConstants.PARAMS, exportParams);
        modelMap.put(MultipleSheetExcelConstants.MULTIPLLE_SHEET_LIST, list);
        return new ModelAndView(MultipleSheetExcelConstants.JEECG_MULTIPLE_SHEET_EXCEL_VIEW);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageResult<PersonalReservation> getPersonalReservation(QueryPersonalReservation queryPersonalReservation) {
        return personalReservationService.getPersonalReservation(queryPersonalReservation);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable(value = "id") String id) {
        return personalReservationService.deleteByPrimaryKey(id);
    }

    @RequestMapping( method = RequestMethod.POST)
    public PersonalReservation insert(@RequestBody @Valid PersonalReservation record) {
        return personalReservationService.insert(record);
    }

    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    public int insertSelective(@RequestBody @Valid PersonalReservation record) {
        return personalReservationService.insertSelective(record);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PersonalReservation selectByPrimaryKey(@PathVariable(value = "id") String id) {
        return personalReservationService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.DELETE)
    public int updateByPrimaryKeySelective(@PathVariable(value = "id") String id,
                                           @RequestBody @Valid PersonalReservation record) {
        return personalReservationService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public PersonalReservation updateByPrimaryKey(@PathVariable(value = "id") String id,
                                         @RequestBody @Valid PersonalReservation record) {
        record.setId(id);
        return personalReservationService.updateByPrimaryKey(record);
    }

}
