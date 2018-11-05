package com.mzhotel.sm.userInfo.controller;

import com.mzhotel.sm.userInfo.dto.UserInfo;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable(value = "id") String id) {
        return userInfoService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert(@RequestBody @Valid UserInfo record) {
        return userInfoService.insert(record);
    }

    @RequestMapping(value = "/insertSelective",method = RequestMethod.POST)
    public int insertSelective(@RequestBody @Valid UserInfo record) {
        return userInfoService.insertSelective(record);
    }

    @RequestMapping(value = "/getOneUser",method = RequestMethod.GET)
    public UserInfo selectByPrimaryKey(@PathVariable(value = "id") String id) {
        return userInfoService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public int updateByPrimaryKeySelective(@RequestBody @Valid UserInfo record) {
        return userInfoService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value = "/updateByPrimaryKey",method = RequestMethod.POST)
    public int updateByPrimaryKey(@RequestBody @Valid UserInfo record) {
        return userInfoService.updateByPrimaryKey(record);
    }
}
