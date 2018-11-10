package com.mzhotel.sm.resource.service;

import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.resource.dto.QueryResource;
import com.mzhotel.sm.resource.dto.Resource;

import java.util.List;

public interface ResourceService {

    int delete(String id);

    Resource insert(Resource record);

    Resource update(Resource record);
    
    List<Resource> getResourceList(QueryResource queryResource);

    PageResult<Resource> getResource(QueryResource queryResource);

    Resource getOneResource(String id);
}
