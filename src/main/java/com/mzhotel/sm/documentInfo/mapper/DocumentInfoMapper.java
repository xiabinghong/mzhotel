package com.mzhotel.sm.documentInfo.mapper;

import com.mzhotel.sm.documentInfo.dto.DocumentInfo;

public interface DocumentInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(DocumentInfo record);

    int insertSelective(DocumentInfo record);

    DocumentInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocumentInfo record);

    int updateByPrimaryKey(DocumentInfo record);
}