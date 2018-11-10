package com.mzhotel.sm.dinnerParty.service;


import com.mzhotel.sm.dinnerParty.dto.DinnerParty;
import com.mzhotel.sm.dinnerParty.dto.QueryDinnerParty;
import com.mzhotel.sm.pageUtil.PageResult;

import java.util.List;

public interface DinnerPartyService {

    void delete(String id);

    DinnerParty insert(DinnerParty record);

    DinnerParty update(DinnerParty record);

    List<DinnerParty> getDinnerPartyList(QueryDinnerParty queryDinnerParty);

    PageResult<DinnerParty> getDinnerParty(QueryDinnerParty queryDinnerParty);

    DinnerParty getOneDinnerParty(String id);
}

