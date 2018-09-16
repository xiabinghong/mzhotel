package com.mzhotel.storehouse.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mzhotel.pageUtil.PageBean;
import com.mzhotel.storehouse.dto.QueryStorehouse;
import com.mzhotel.storehouse.dto.Storehouse;
import com.mzhotel.storehouse.service.StorehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/storehouse")
public class StorehouseController {

    @Autowired
    StorehouseService storehouseService;

    @RequestMapping(value = "getStorehouseList", method = RequestMethod.GET)
    public List<Storehouse> getStorehouseList(QueryStorehouse queryStorehouse) {
        return storehouseService.getStorehouseList(queryStorehouse);
    }

    @RequestMapping(value = "getStorehouse", method = RequestMethod.GET)
    public PageBean<Storehouse> getStorehouse(QueryStorehouse queryStorehouse) {
        return storehouseService.getStorehouse(queryStorehouse);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable(value = "id") String id) {
        return storehouseService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int insert(@RequestBody @Valid Storehouse record) {
        return storehouseService.insert(record);
    }

    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    public int insertSelective(@RequestBody @Valid Storehouse record) {
        return storehouseService.insertSelective(record);
    }

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public Storehouse selectByPrimaryKey(@PathVariable(value = "id") String id) {
        return storehouseService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.DELETE)
    public int updateByPrimaryKeySelective(@PathVariable(value = "id") String id,
                                           @RequestBody @Valid Storehouse record) {
        return storehouseService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.DELETE)
    public int updateByPrimaryKey(@PathVariable(value = "id") String id,
                                  @RequestBody @Valid Storehouse record) {
        return storehouseService.updateByPrimaryKey(record);
    }

}
