package com.mzhotel.documentInfo.service.impl;

import com.mzhotel.documentInfo.dto.DocumentInfo;
import com.mzhotel.documentInfo.mapper.DocumentInfoMapper;
import com.mzhotel.documentInfo.service.DocumentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocumentInfoServiceImpl implements DocumentInfoService {

    @Autowired
    DocumentInfoMapper documentInfoMapper;

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id){
        return documentInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insert(DocumentInfo record){
        return documentInfoMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(DocumentInfo record){
        return documentInfoMapper.insertSelective(record);
    }

    @Override
    public DocumentInfo selectByPrimaryKey(String id){
        return documentInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(DocumentInfo record){
        return documentInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(DocumentInfo record){
        return documentInfoMapper.updateByPrimaryKey(record);
    }
}
