package com.mzhotel.sm.dictInfo.controller;

import com.mzhotel.sm.dictInfo.dto.DictInfo;
import com.mzhotel.sm.dictInfo.service.DictInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/dictInfo")
public class DictInfoController {

    @Autowired
    DictInfoService dictInfoService;

    @RequestMapping(method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable(value = "id") String id) {
        return dictInfoService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insert(@RequestBody @Valid DictInfo record) {
        return dictInfoService.insert(record);
    }

    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    public int insertSelective(@RequestBody @Valid DictInfo record) {
        return dictInfoService.insertSelective(record);
    }

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public DictInfo selectByPrimaryKey(@PathVariable(value = "id") String id) {
        return dictInfoService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.DELETE)
    public int updateByPrimaryKeySelective(@PathVariable(value = "id") String id,
                                           @RequestBody @Valid DictInfo record) {
        return dictInfoService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.DELETE)
    public int updateByPrimaryKey(@PathVariable(value = "id") String id,
                                  @RequestBody @Valid DictInfo record) {
        return dictInfoService.updateByPrimaryKey(record);
    }

}
