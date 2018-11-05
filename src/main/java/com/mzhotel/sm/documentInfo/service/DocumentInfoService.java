package com.mzhotel.sm.documentInfo.service;


import com.mzhotel.sm.documentInfo.dto.DocumentInfo;

public interface DocumentInfoService {

    int deleteByPrimaryKey(String id);

    DocumentInfo insert(DocumentInfo record);

    int insertSelective(DocumentInfo record);

    DocumentInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DocumentInfo record);

    int updateByPrimaryKey(DocumentInfo record);
}
