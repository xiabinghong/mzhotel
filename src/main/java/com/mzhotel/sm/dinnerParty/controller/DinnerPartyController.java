package com.mzhotel.sm.dinnerParty.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.dinnerParty.dto.QueryDinnerParty;
import com.mzhotel.sm.dinnerParty.dto.DinnerParty;
import com.mzhotel.sm.dinnerParty.service.DinnerPartyService;
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
@RequestMapping(value = "/dinnerParty")
public class DinnerPartyController {

    @Autowired
    DinnerPartyService dinnerPartyService;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(method = RequestMethod.GET)
    public PageResult<DinnerParty> getDinnerParty(QueryDinnerParty queryDinnerParty) {
        return dinnerPartyService.getDinnerParty(queryDinnerParty);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteByPrimaryKey(@PathVariable(value = "id") String id) {
        dinnerPartyService.deleteByPrimaryKey(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public DinnerParty insert(@RequestBody @Valid DinnerParty record) {
        return dinnerPartyService.insert(record);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public DinnerParty update(@PathVariable(value = "id") String id,
                      @RequestBody @Valid DinnerParty record) {
        record.setId(id);
        return dinnerPartyService.update(record);
    }

}
