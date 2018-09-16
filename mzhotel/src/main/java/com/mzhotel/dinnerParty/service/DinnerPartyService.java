package com.mzhotel.dinnerParty.service;


import com.mzhotel.dinnerParty.dto.DinnerParty;

public interface DinnerPartyService {

    int deleteByPrimaryKey(String id);

    int insert(DinnerParty record);

    int insertSelective(DinnerParty record);

    DinnerParty selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DinnerParty record);

    int updateByPrimaryKey(DinnerParty record);
}
