package com.mzhotel.sm.documentInfo.service.impl;

import com.mzhotel.sm.documentInfo.dto.DocumentInfo;
import com.mzhotel.sm.documentInfo.mapper.DocumentInfoMapper;
import com.mzhotel.sm.documentInfo.service.DocumentInfoService;
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
    public DocumentInfo insert(DocumentInfo record){
        int result = documentInfoMapper.insert(record);
        if(result == 1){
            return selectByPrimaryKey(record.getId());
        }else {
            return null;
        }
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
