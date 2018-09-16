package com.mzhotel.documentInfoRelation.mapper;

import com.mzhotel.documentInfoRelation.dto.DocumentInfoRelation;

public interface DocumentInfoRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(DocumentInfoRelation record);

    int insertSelective(DocumentInfoRelation record);

    DocumentInfoRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocumentInfoRelation record);

    int updateByPrimaryKey(DocumentInfoRelation record);
}