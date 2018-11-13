package com.mzhotel.sm.actionLog.controller;

import com.mzhotel.sm.actionLog.dto.ActionLog;
import com.mzhotel.sm.actionLog.dto.QueryActionLog;
import com.mzhotel.sm.actionLog.service.ActionLogService;
import com.mzhotel.sm.pageUtil.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/actionLog")
public class ActionLogController {

    @Autowired
    ActionLogService actionLogService;

    @RequestMapping(value = "/queryActionLogList", method = RequestMethod.GET)
    public List<ActionLog> queryActionLogList(QueryActionLog queryActionLog) {
        return actionLogService.queryActionLogList(queryActionLog);
    }

    @RequestMapping(value = "/queryActionLog", method = RequestMethod.GET)
    public PageResult<ActionLog> queryActionLog(QueryActionLog queryActionLog) {
        return actionLogService.queryActionLog(queryActionLog);
    }

}
