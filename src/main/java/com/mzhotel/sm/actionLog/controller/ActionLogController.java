package com.mzhotel.sm.actionLog.controller;

import com.mzhotel.sm.actionLog.dto.ActionLog;
import com.mzhotel.sm.actionLog.dto.QueryActionLog;
import com.mzhotel.sm.actionLog.service.ActionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/actionLog")
public class ActionLogController {

    @Autowired
    ActionLogService actionLogService;

    @RequestMapping(value = "/queryActionLog", method = RequestMethod.GET)
    public List<ActionLog> queryActionLog(QueryActionLog queryActionLog) {
        return actionLogService.queryActionLog(queryActionLog);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable(value = "id") String id) {
        return actionLogService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insert(@RequestBody @Valid ActionLog record) {
        return actionLogService.insert(record);
    }

    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    public int insertSelective(@RequestBody @Valid ActionLog record) {
        return actionLogService.insertSelective(record);
    }

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public ActionLog selectByPrimaryKey(@PathVariable(value = "id") String id) {
        return actionLogService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.DELETE)
    public int updateByPrimaryKeySelective(@PathVariable(value = "id") String id,
                                           @RequestBody @Valid ActionLog record) {
        return actionLogService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.DELETE)
    public int updateByPrimaryKey(@PathVariable(value = "id") String id,
                                  @RequestBody @Valid ActionLog record) {
        return actionLogService.updateByPrimaryKey(record);
    }

}
