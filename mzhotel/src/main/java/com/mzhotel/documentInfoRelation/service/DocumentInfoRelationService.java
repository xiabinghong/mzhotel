package com.mzhotel.documentInfoRelation.service;

import com.mzhotel.documentInfoRelation.dto.DocumentInfoRelation;

public interface DocumentInfoRelationService {

    int deleteByPrimaryKey(String id);

    int insert(DocumentInfoRelation record);

    int insertSelective(DocumentInfoRelation record);

    DocumentInfoRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocumentInfoRelation record);

    int updateByPrimaryKey(DocumentInfoRelation record);
}
