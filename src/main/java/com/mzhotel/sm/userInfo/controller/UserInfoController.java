package com.mzhotel.sm.userInfo.controller;

import com.mzhotel.sm.login.dto.QueryUserInfo;
import com.mzhotel.sm.pageUtil.PageResult;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteByPrimaryKey(@PathVariable(value = "id") String id) {
        userInfoService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserInfo insert(@RequestBody @Valid UserInfo record) {
        return userInfoService.insert(record);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserInfo selectOne(@PathVariable(value = "id") String id) {
        return userInfoService.selectOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public UserInfo update(@RequestBody @Valid UserInfo record,
                           @PathVariable(value = "id") String id) {
        record.setId(id);
        return userInfoService.update(record);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageResult<UserInfo> queryPage(QueryUserInfo queryUserInfo) {
        return userInfoService.queryPage(queryUserInfo);
    }
}
