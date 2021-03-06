package com.mzhotel.sm.documentInfoRelation.service;

import com.mzhotel.sm.documentInfoRelation.dto.DocumentInfoRelation;

public interface DocumentInfoRelationService {

    int deleteByPrimaryKey(String id);

    int insert(DocumentInfoRelation record);

    int insertSelective(DocumentInfoRelation record);

    DocumentInfoRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocumentInfoRelation record);

    int updateByPrimaryKey(DocumentInfoRelation record);
}
