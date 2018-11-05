package com.mzhotel.sm.dinnerParty.service;


import com.mzhotel.sm.dinnerParty.dto.DinnerParty;
import com.mzhotel.sm.dinnerParty.dto.QueryDinnerParty;
import com.mzhotel.sm.pageUtil.PageResult;

import java.util.List;

public interface DinnerPartyService {

    int deleteByPrimaryKey(String id);

    int insert(DinnerParty record);

    int insertSelective(DinnerParty record);

    DinnerParty selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DinnerParty record);

    int updateByPrimaryKey(DinnerParty record);

    List<DinnerParty> getDinnerPartyList(QueryDinnerParty queryDinnerParty);

    PageResult<DinnerParty> getDinnerParty(QueryDinnerParty queryDinnerParty);

    DinnerParty getOneDinnerParty(String id);
}

