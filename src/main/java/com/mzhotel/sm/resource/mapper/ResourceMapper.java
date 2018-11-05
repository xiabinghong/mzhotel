package com.mzhotel.sm.resource.mapper;

import com.mzhotel.sm.resource.dto.QueryResource;
import com.mzhotel.sm.resource.dto.Resource;


import java.util.List;

public interface ResourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<Resource> getResource(QueryResource queryResource);
}