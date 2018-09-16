package com.mzhotel.dictInfo.service.impl;

import com.mzhotel.dictInfo.dto.DictInfo;
import com.mzhotel.dictInfo.mapper.DictInfoMapper;
import com.mzhotel.dictInfo.service.DictInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DictInfoServiceImpl implements DictInfoService {

    @Autowired
    DictInfoMapper dictInfoMapper;

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id){
        return dictInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insert(DictInfo record){
        return dictInfoMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(DictInfo record){
        return dictInfoMapper.insertSelective(record);
    }

    @Override
    public DictInfo selectByPrimaryKey(String id){
        return dictInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(DictInfo record){
        return dictInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(DictInfo record){
        return dictInfoMapper.updateByPrimaryKey(record);
    }
}
