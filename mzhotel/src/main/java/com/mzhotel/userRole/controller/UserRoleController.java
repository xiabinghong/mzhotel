package com.mzhotel.userRole.controller;

import com.mzhotel.userRole.dto.UserRoleRelation;
import com.mzhotel.userRole.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/UserRoleRelation")
public class UserRoleController {
    
    @Autowired
    UserRoleService userRoleService;

    @RequestMapping(method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable(value = "id") String id){
        return userRoleService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public int insert(@RequestBody @Valid UserRoleRelation record){
        return userRoleService.insert(record);
    }

    @RequestMapping(value="/insertSelective",method = RequestMethod.POST)
    public int insertSelective(@RequestBody @Valid UserRoleRelation record){
        return userRoleService.insertSelective(record);
    }

    @RequestMapping(value="/selectByPrimaryKey",method = RequestMethod.GET)
    public UserRoleRelation selectByPrimaryKey(@PathVariable(value = "id") String id){
        return userRoleService.selectByPrimaryKey(id);
    }

    @RequestMapping(value="/updateByPrimaryKeySelective",method = RequestMethod.DELETE)
    public int updateByPrimaryKeySelective(@PathVariable(value = "id") String id,
                                           @RequestBody @Valid UserRoleRelation record){
        return userRoleService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value="/updateByPrimaryKey",method = RequestMethod.DELETE)
    public int updateByPrimaryKey(@PathVariable(value = "id") String id,
                                  @RequestBody @Valid UserRoleRelation record){
        return userRoleService.updateByPrimaryKey(record);
    }
    
}
