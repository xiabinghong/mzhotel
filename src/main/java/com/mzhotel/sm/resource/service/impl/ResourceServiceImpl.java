package com.mzhotel.sm.resource.service.impl;

import com.mzhotel.sm.documentInfoRelation.service.DocumentInfoRelationService;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.resource.dto.Resource;
import com.mzhotel.sm.resource.mapper.ResourceMapper;
import com.mzhotel.sm.resource.service.ResourceService;
import com.mzhotel.sm.resource.dto.QueryResource;
import com.mzhotel.sm.resource.dto.Resource;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import com.mzhotel.sm.util.MyBatisDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceMapper resourceMapper;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    MyBatisDAO<Resource> myBatisDAO;

    @Autowired
    DocumentInfoRelationService documentInfoRelationService;

    private static final String mapper = "ResourceMapper";

    @Override
    @Transactional
    public int delete(String id){
        return resourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Resource getOneResource(String id) {
        if (id == null) {
            return null;
        }
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Resource insert(Resource record){
        record.setCreatedBy(userInfoService.getCurrUser());
        record.setCreatedDate(new Date());
        int result = resourceMapper.insert(record);
        if(result == 1){
            return getOneResource(record.getId());
        }
        return null;
    }

    @Override
    @Transactional
    public Resource update(Resource record){
        record.setUpdatedBy(userInfoService.getCurrUser());
        record.setUpdatedDate(new Date());
        int result = resourceMapper.updateByPrimaryKeySelective(record);
        if(result == 1){
            return getOneResource(record.getId());
        }
        return null;
    }

    @Override
    public List<Resource> getResourceList(QueryResource queryResource) {
        return resourceMapper.getResource(queryResource);
    }

    @Override
    public PageResult<Resource> getResource(QueryResource queryResource) {
        List<Resource> resourceList = getResourceList(queryResource);
        return myBatisDAO.queryPage(resourceList,queryResource.getPageNum(), queryResource.getPageSize());
    }
}
