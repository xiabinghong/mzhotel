package com.mzhotel.sm.resource.controller;

import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.resource.dto.Resource;
import com.mzhotel.sm.resource.service.ResourceService;
import com.mzhotel.sm.resource.dto.QueryResource;
import com.mzhotel.sm.resource.dto.Resource;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/resource")
public class ResourceController {
    
    @Autowired
    ResourceService resourceService;
    
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/getResourceList", method = RequestMethod.GET)
    public List<Resource> getResourceList(QueryResource queryResource) {
        userInfoService.getCurrUser();
        return resourceService.getResourceList(queryResource);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public PageResult<Resource> getResource(QueryResource queryResource) {
        return resourceService.getResource(queryResource);
    }
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
