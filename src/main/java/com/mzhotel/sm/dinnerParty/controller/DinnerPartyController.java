package com.mzhotel.sm.dinnerParty.controller;

import com.mzhotel.sm.dinnerParty.dto.DinnerParty;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.dinnerParty.dto.QueryDinnerParty;
import com.mzhotel.sm.dinnerParty.service.DinnerPartyService;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") String id) {
        dinnerPartyService.delete(id);
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DinnerParty selectOne(@PathVariable(value = "id") String id) {
        return dinnerPartyService.getOneDinnerParty(id);
    }

}
