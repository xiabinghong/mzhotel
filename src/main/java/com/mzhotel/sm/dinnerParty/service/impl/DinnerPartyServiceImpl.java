package com.mzhotel.sm.dinnerParty.service.impl;

import com.mzhotel.sm.dinnerParty.dto.DinnerParty;
import com.mzhotel.sm.dinnerParty.dto.QueryDinnerParty;
import com.mzhotel.sm.dinnerParty.mapper.DinnerPartyMapper;
import com.mzhotel.sm.dinnerParty.service.DinnerPartyService;
import com.mzhotel.sm.documentInfoRelation.service.DocumentInfoRelationService;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import com.mzhotel.sm.util.MyBatisDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DinnerPartyServiceImpl implements DinnerPartyService {

    @Autowired
    DinnerPartyMapper dinnerPartyMapper;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    MyBatisDAO<DinnerParty> myBatisDAO;

    @Autowired
    DocumentInfoRelationService documentInfoRelationService;

    @Override
    @Transactional
    public int deleteByPrimaryKey(String id) {
        return dinnerPartyMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public DinnerParty insert(DinnerParty record) {
        int result = dinnerPartyMapper.insert(record);
        if (result == 1) {
            return getOneDinnerParty(record.getId());
        }
        return null;
    }

    @Override
    @Transactional
    public DinnerParty update(DinnerParty record) {
        int result = dinnerPartyMapper.updateByPrimaryKeySelective(record);
        if(result == 1){
            return getOneDinnerParty(record.getId());
        }
        return null;
    }

    @Override
    public List<DinnerParty> getDinnerPartyList(QueryDinnerParty queryDinnerParty) {
        return dinnerPartyMapper.getDinnerParty(queryDinnerParty);
    }

    @Override
    public PageResult<DinnerParty> getDinnerParty(QueryDinnerParty queryDinnerParty) {
        List<DinnerParty> dinnerPartyList = getDinnerPartyList(queryDinnerParty);
        return myBatisDAO.queryPage(dinnerPartyList, queryDinnerParty.getPageNum(), queryDinnerParty.getPageSize());
    }

    @Override
    public DinnerParty getOneDinnerParty(String id) {
        if (id == null) {
            return null;
        }
        return dinnerPartyMapper.selectByPrimaryKey(id);
    }


}
