package com.mzhotel.sm.dictInfo.service;

import com.mzhotel.sm.dictInfo.dto.DictInfo;

public interface DictInfoService {

    int deleteByPrimaryKey(String id);

    int insert(DictInfo record);

    int insertSelective(DictInfo record);

    DictInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DictInfo record);

    int updateByPrimaryKey(DictInfo record);
}
