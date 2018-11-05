package com.mzhotel.sm.documentInfoRelation.mapper;

import com.mzhotel.sm.documentInfoRelation.dto.DocumentInfoRelation;

public interface DocumentInfoRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(DocumentInfoRelation record);

    int insertSelective(DocumentInfoRelation record);

    DocumentInfoRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocumentInfoRelation record);

    int updateByPrimaryKey(DocumentInfoRelation record);
}