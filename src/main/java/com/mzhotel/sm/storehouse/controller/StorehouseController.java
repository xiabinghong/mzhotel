package com.mzhotel.sm.storehouse.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mzhotel.sm.actionLog.dto.ActionLog;
import com.mzhotel.sm.actionLog.dto.QueryActionLog;
import com.mzhotel.sm.actionLog.service.ActionLogService;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.storehouse.dto.QueryStorehouse;
import com.mzhotel.sm.storehouse.dto.Storehouse;
import com.mzhotel.sm.storehouse.service.StorehouseService;
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
@RequestMapping(value = "/storehouse")
public class StorehouseController {

    @Autowired
    StorehouseService storehouseService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    ActionLogService actionLogService;

    @RequestMapping(value = "/getStorehouseList", method = RequestMethod.GET)
    public List<Storehouse> getStorehouseList(QueryStorehouse queryStorehouse) {
        userInfoService.getCurrUser();
        return storehouseService.getStorehouseList(queryStorehouse);
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public ModelAndView exportData(QueryStorehouse queryStorehouse, ModelMap modelMap) {
        List<Map<String, Object>> list = Lists.newArrayList();
        List<Storehouse> storehouseList = storehouseService.getStorehouseList(queryStorehouse);
        Map<String, Object> params = Maps.newHashMap();
        ExportParams storehouseparams = new ExportParams();
        storehouseparams.setTitle("仓库管理");
        storehouseparams.setSheetName("仓库管理");
        params.put("title", storehouseparams);
        params.put("entity", Storehouse.class);
        params.put("data", storehouseList);
        list.add(params);
        ExportParams exportParams = new ExportParams();
        exportParams.setType(ExcelType.HSSF);
        modelMap.put(MultipleSheetExcelConstants.FILE_NAME, "仓库管理");
        modelMap.put(MultipleSheetExcelConstants.PARAMS, exportParams);
        modelMap.put(MultipleSheetExcelConstants.MULTIPLLE_SHEET_LIST, list);
        return new ModelAndView(MultipleSheetExcelConstants.JEECG_MULTIPLE_SHEET_EXCEL_VIEW);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageResult<Storehouse> getStorehouse(QueryStorehouse queryStorehouse) {
        return storehouseService.getStorehouse(queryStorehouse);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable(value = "id") String id) {
        return storehouseService.deleteByPrimaryKey(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Storehouse insert(@RequestBody @Valid Storehouse record) {
        return storehouseService.insert(record);
    }

    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    public int insertSelective(@RequestBody @Valid Storehouse record) {
        return storehouseService.insertSelective(record);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Storehouse selectByPrimaryKey(@PathVariable(value = "id") String id) {
        return storehouseService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Storehouse updateByPrimaryKey(@PathVariable(value = "id") String id,
                                         @RequestBody @Valid Storehouse record) {
        record.setId(id);
        return storehouseService.updateByPrimaryKey(record);
    }

    @RequestMapping(value = "/innerOrOutStore", method = RequestMethod.POST)
    public void innerStore(@RequestBody @Valid ActionLog actionLog) {
        //更新仓库的存储量
        Storehouse storehouse = new Storehouse();
        storehouse.setId(actionLog.getParentId());
        storehouse.setAmount(actionLog.getStoreSumAmount());
        storehouseService.updateByPrimaryKey(storehouse);
        //添加操作日志
        actionLogService.insert(actionLog);
    }

    @RequestMapping(value = "/storeLog", method = RequestMethod.GET)
    public List<ActionLog> storeLog(QueryActionLog queryActionLog) {
        return actionLogService.queryActionLog(queryActionLog);
    }

}
