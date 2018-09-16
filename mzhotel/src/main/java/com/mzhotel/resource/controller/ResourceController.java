package com.mzhotel.resource.controller;

import com.mzhotel.resource.dto.Resource;
import com.mzhotel.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/resource")
public class ResourceController {
    
    @Autowired
    ResourceService resourceService;

    @RequestMapping(method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable(value = "id") String id){
        return resourceService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public int insert(@RequestBody @Valid Resource record){
        return resourceService.insert(record);
    }

    @RequestMapping(value="/insertSelective",method = RequestMethod.POST)
    public int insertSelective(@RequestBody @Valid Resource record){
        return resourceService.insertSelective(record);
    }

    @RequestMapping(value="/selectByPrimaryKey",method = RequestMethod.GET)
    public Resource selectByPrimaryKey(@PathVariable(value = "id") String id){
        return resourceService.selectByPrimaryKey(id);
    }

    @RequestMapping(value="/updateByPrimaryKeySelective",method = RequestMethod.DELETE)
    public int updateByPrimaryKeySelective(@PathVariable(value = "id") String id,
                                           @RequestBody @Valid Resource record){
        return resourceService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value="/updateByPrimaryKey",method = RequestMethod.DELETE)
    public int updateByPrimaryKey(@PathVariable(value = "id") String id,
                                  @RequestBody @Valid Resource record){
        return resourceService.updateByPrimaryKey(record);
    }
    
}
