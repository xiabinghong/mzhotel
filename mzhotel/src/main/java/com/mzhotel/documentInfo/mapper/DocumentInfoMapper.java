package com.mzhotel.documentInfo.mapper;

import com.mzhotel.documentInfo.dto.DocumentInfo;

public interface DocumentInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(DocumentInfo record);

    int insertSelective(DocumentInfo record);

    DocumentInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocumentInfo record);

    int updateByPrimaryKey(DocumentInfo record);
}