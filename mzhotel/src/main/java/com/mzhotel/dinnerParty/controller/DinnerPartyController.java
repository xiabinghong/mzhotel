package com.mzhotel.dinnerParty.controller;

import com.mzhotel.dinnerParty.dto.DinnerParty;
import com.mzhotel.dinnerParty.service.DinnerPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/dinnerParty")
public class DinnerPartyController {
    
    @Autowired
    DinnerPartyService dinnerPartyService;

    @RequestMapping(method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable(value = "id") String id){
        return dinnerPartyService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public int insert(@RequestBody @Valid DinnerParty record){
        return dinnerPartyService.insert(record);
    }

    @RequestMapping(value="/insertSelective",method = RequestMethod.POST)
    public int insertSelective(@RequestBody @Valid DinnerParty record){
        return dinnerPartyService.insertSelective(record);
    }

    @RequestMapping(value="/selectByPrimaryKey",method = RequestMethod.GET)
    public DinnerParty selectByPrimaryKey(@PathVariable(value = "id") String id){
        return dinnerPartyService.selectByPrimaryKey(id);
    }

    @RequestMapping(value="/updateByPrimaryKeySelective",method = RequestMethod.DELETE)
    public int updateByPrimaryKeySelective(@PathVariable(value = "id") String id,
                                           @RequestBody @Valid DinnerParty record){
        return dinnerPartyService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value="/updateByPrimaryKey",method = RequestMethod.DELETE)
    public int updateByPrimaryKey(@PathVariable(value = "id") String id,
                                  @RequestBody @Valid DinnerParty record){
        return dinnerPartyService.updateByPrimaryKey(record);
    }
    
}
