package com.mzhotel.documentInfoRelation.service.impl;

import com.mzhotel.documentInfoRelation.dto.DocumentInfoRelation;
import com.mzhotel.documentInfoRelation.mapper.DocumentInfoRelationMapper;
import com.mzhotel.documentInfoRelation.service.DocumentInfoRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocumentInfoRelationServiceImpl implements DocumentInfoRelationService {

    @Autowired
    DocumentInfoRelationMapper documentInfoRelationMapper;

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id) {
        return documentInfoRelationMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insert(DocumentInfoRelation record) {
        return documentInfoRelationMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(DocumentInfoRelation record) {
        return documentInfoRelationMapper.insertSelective(record);
    }

    @Override
    public DocumentInfoRelation selectByPrimaryKey(String id) {
        return documentInfoRelationMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(DocumentInfoRelation record) {
        return documentInfoRelationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(DocumentInfoRelation record) {
        return documentInfoRelationMapper.updateByPrimaryKey(record);
    }
}
