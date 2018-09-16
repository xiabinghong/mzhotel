package com.mzhotel.documentInfo.controller;

import com.mzhotel.documentInfo.dto.DocumentInfo;
import com.mzhotel.documentInfo.service.DocumentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/documentInfo")
public class DocumentInfoController {
    
    @Autowired
    DocumentInfoService documentInfoService;

    @RequestMapping(method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable(value = "id") String id){
        return documentInfoService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public int insert(@RequestBody @Valid DocumentInfo record){
        return documentInfoService.insert(record);
    }

    @RequestMapping(value="/insertSelective",method = RequestMethod.POST)
    public int insertSelective(@RequestBody @Valid DocumentInfo record){
        return documentInfoService.insertSelective(record);
    }

    @RequestMapping(value="/selectByPrimaryKey",method = RequestMethod.GET)
    public DocumentInfo selectByPrimaryKey(@PathVariable(value = "id") String id){
        return documentInfoService.selectByPrimaryKey(id);
    }

    @RequestMapping(value="/updateByPrimaryKeySelective",method = RequestMethod.DELETE)
    public int updateByPrimaryKeySelective(@PathVariable(value = "id") String id,
                                           @RequestBody @Valid DocumentInfo record){
        return documentInfoService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value="/updateByPrimaryKey",method = RequestMethod.DELETE)
    public int updateByPrimaryKey(@PathVariable(value = "id") String id,
                                  @RequestBody @Valid DocumentInfo record){
        return documentInfoService.updateByPrimaryKey(record);
    }
    
}
