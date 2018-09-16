package com.mzhotel.resource.service.impl;

import com.mzhotel.resource.dto.Resource;
import com.mzhotel.resource.mapper.ResourceMapper;
import com.mzhotel.resource.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    ResourceMapper resourceMapper;

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id){
        return resourceMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insert(Resource record){
        return resourceMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(Resource record){
        return resourceMapper.insertSelective(record);
    }

    @Override
    public Resource selectByPrimaryKey(String id){
        return resourceMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(Resource record){
        return resourceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(Resource record){
        return resourceMapper.updateByPrimaryKey(record);
    }
}
