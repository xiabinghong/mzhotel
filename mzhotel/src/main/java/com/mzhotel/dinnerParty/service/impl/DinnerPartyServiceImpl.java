package com.mzhotel.dinnerParty.service.impl;

import com.mzhotel.dinnerParty.dto.DinnerParty;
import com.mzhotel.dinnerParty.mapper.DinnerPartyMapper;
import com.mzhotel.dinnerParty.service.DinnerPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DinnerPartyServiceImpl implements DinnerPartyService {

    @Autowired
    DinnerPartyMapper dinnerPartyMapper;

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id){
        return dinnerPartyMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insert(DinnerParty record){
        return dinnerPartyMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(DinnerParty record){
        return dinnerPartyMapper.insertSelective(record);
    }

    @Override
    public DinnerParty selectByPrimaryKey(String id){
        return dinnerPartyMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(DinnerParty record){
        return dinnerPartyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(DinnerParty record){
        return dinnerPartyMapper.updateByPrimaryKey(record);
    }
}
