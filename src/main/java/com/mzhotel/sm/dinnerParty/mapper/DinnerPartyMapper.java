package com.mzhotel.sm.dinnerParty.mapper;

import com.mzhotel.sm.dinnerParty.dto.DinnerParty;
import com.mzhotel.sm.dinnerParty.dto.QueryDinnerParty;

import java.util.List;

public interface DinnerPartyMapper {
    int deleteByPrimaryKey(String id);

    int insert(DinnerParty record);

    int insertSelective(DinnerParty record);

    DinnerParty selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DinnerParty record);

    int updateByPrimaryKey(DinnerParty record);
    
    List<DinnerParty> getDinnerParty(QueryDinnerParty queryDinnerParty);
}