package com.mzhotel.sm.role.controller;

import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.role.dto.Role;
import com.mzhotel.sm.role.service.RoleService;
import com.mzhotel.sm.role.dto.QueryRole;
import com.mzhotel.sm.role.dto.Role;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/getRoleList", method = RequestMethod.GET)
    public List<Role> getRoleList(QueryRole queryRole) {
        userInfoService.getCurrUser();
        return roleService.getRoleList(queryRole);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageResult<Role> getRole(QueryRole queryRole) {
        return roleService.getRole(queryRole);
    }
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable(value = "id") String id){
        return roleService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public int insert(@RequestBody @Valid Role record){
        return roleService.insert(record);
    }

    @RequestMapping(value="/insertSelective",method = RequestMethod.POST)
    public int insertSelective(@RequestBody @Valid Role record){
        return roleService.insertSelective(record);
    }

    @RequestMapping(value="/selectByPrimaryKey",method = RequestMethod.GET)
    public Role selectByPrimaryKey(@PathVariable(value = "id") String id){
        return roleService.selectByPrimaryKey(id);
    }

    @RequestMapping(value="/updateByPrimaryKeySelective",method = RequestMethod.DELETE)
    public int updateByPrimaryKeySelective(@PathVariable(value = "id") String id,
                                           @RequestBody @Valid Role record){
        return roleService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value="/updateByPrimaryKey",method = RequestMethod.DELETE)
    public int updateByPrimaryKey(@PathVariable(value = "id") String id,
                                  @RequestBody @Valid Role record){
        return roleService.updateByPrimaryKey(record);
    }



}
