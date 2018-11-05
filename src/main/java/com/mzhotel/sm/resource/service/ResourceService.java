package com.mzhotel.sm.resource.service;

import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.resource.dto.QueryResource;
import com.mzhotel.sm.resource.dto.Resource;

import java.util.List;

public interface ResourceService {

    int deleteByPrimaryKey(String id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
    
    List<Resource> getResourceList(QueryResource queryResource);

    PageResult<Resource> getResource(QueryResource queryResource);

    Resource getOneResource(String id);
}
