package com.mzhotel.sm.userRole.controller;

import com.mzhotel.sm.userRole.dto.UserRoleRelation;
import com.mzhotel.sm.userRole.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/UserRoleRelation")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") String id) {
        userRoleService.delete(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public UserRoleRelation insert(@RequestBody @Valid UserRoleRelation record) {
        return userRoleService.insert(record);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserRoleRelation selectOne(@PathVariable(value = "id") String id) {
        return userRoleService.selectOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public UserRoleRelation update(@PathVariable(value = "id") String id,
                                   @RequestBody @Valid UserRoleRelation record) {
        record.setId(id);
        return userRoleService.update(record);
    }

}
