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
@RequestMapping(value = "/DinnerParty")
public class DinnerPartyController {

    @Autowired
    DinnerPartyService DinnerPartyService;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/getDinnerPartyList", method = RequestMethod.GET)
    public List<DinnerParty> getDinnerPartyList(QueryDinnerParty queryDinnerParty) {
        userInfoService.getCurrUser();
        return DinnerPartyService.getDinnerPartyList(queryDinnerParty);
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public ModelAndView exportData(QueryDinnerParty queryDinnerParty, ModelMap modelMap) {
        List<Map<String,Object>> list = Lists.newArrayList();
        List<DinnerParty> DinnerPartyList = DinnerPartyService.getDinnerPartyList(queryDinnerParty);
        Map<String,Object> params = Maps.newHashMap();
        ExportParams DinnerPartyparams = new ExportParams();
        DinnerPartyparams.setTitle("仓库管理");
        DinnerPartyparams.setSheetName("仓库管理");
        params.put("title",DinnerPartyparams);
        params.put("entity",DinnerParty.class);
        params.put("data",DinnerPartyList);
        list.add(params);
        ExportParams exportParams = new ExportParams();
        exportParams.setType(ExcelType.HSSF);
        modelMap.put(MultipleSheetExcelConstants.FILE_NAME, "仓库管理");
        modelMap.put(MultipleSheetExcelConstants.PARAMS, exportParams);
        modelMap.put(MultipleSheetExcelConstants.MULTIPLLE_SHEET_LIST, list);
        return new ModelAndView(MultipleSheetExcelConstants.JEECG_MULTIPLE_SHEET_EXCEL_VIEW);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageResult<DinnerParty> getDinnerParty(QueryDinnerParty queryDinnerParty) {
        return DinnerPartyService.getDinnerParty(queryDinnerParty);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable(value = "id") String id) {
        return DinnerPartyService.deleteByPrimaryKey(id);
    }

    @RequestMapping( method = RequestMethod.POST)
    public int insert(@RequestBody @Valid DinnerParty record) {
        return DinnerPartyService.insert(record);
    }

    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    public int insertSelective(@RequestBody @Valid DinnerParty record) {
        return DinnerPartyService.insertSelective(record);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DinnerParty selectByPrimaryKey(@PathVariable(value = "id") String id) {
        return DinnerPartyService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.DELETE)
    public int updateByPrimaryKeySelective(@PathVariable(value = "id") String id,
                                           @RequestBody @Valid DinnerParty record) {
        return DinnerPartyService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public int updateByPrimaryKey(@PathVariable(value = "id") String id,
                                         @RequestBody @Valid DinnerParty record) {
        record.setId(id);
        return DinnerPartyService.updateByPrimaryKey(record);
    }

}
