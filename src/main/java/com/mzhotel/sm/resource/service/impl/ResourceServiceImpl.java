package com.mzhotel.sm.resource.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mzhotel.sm.actionLog.dto.ActionLogEnum;
import com.mzhotel.sm.actionLog.service.ActionLogService;
import com.mzhotel.sm.documentInfoRelation.service.DocumentInfoRelationService;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.resource.dto.QueryResource;
import com.mzhotel.sm.resource.dto.Resource;
import com.mzhotel.sm.resource.mapper.ResourceMapper;
import com.mzhotel.sm.resource.service.ResourceService;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceMapper resourceMapper;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    ActionLogService actionLogService;

    @Autowired
    DocumentInfoRelationService documentInfoRelationService;

    private static final String mapper = "ResourceMapper";

    @Override
    @Transactional
    public int delete(String id) {
        actionLogService.insert(id, ActionLogEnum.DELETE);
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
    public Resource insert(Resource record) {
        record.setCreatedBy(userInfoService.getCurrUser());
        record.setCreatedDate(new Date());
        int result = resourceMapper.insert(record);
        if (result == 1) {
            actionLogService.insert(record.getId(), ActionLogEnum.SAVE);
            return getOneResource(record.getId());
        }
        return null;
    }

    @Override
    @Transactional
    public Resource update(Resource record) {
        record.setUpdatedBy(userInfoService.getCurrUser());
        record.setUpdatedDate(new Date());
        int result = resourceMapper.updateByPrimaryKeySelective(record);
        if (result == 1) {
            actionLogService.insert(record.getId(), ActionLogEnum.UPDATE);
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
        PageHelper.startPage(queryResource.getPageNum(), queryResource.getPageSize());
        List<Resource> resourceList = getResourceList(queryResource);
        return new PageResult<Resource>((Page<Resource>) resourceList);
    }
}
