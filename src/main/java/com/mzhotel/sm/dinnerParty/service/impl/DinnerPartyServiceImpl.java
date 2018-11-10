package com.mzhotel.sm.dinnerParty.service.impl;

import com.mzhotel.sm.dinnerParty.dto.DinnerParty;
import com.mzhotel.sm.dinnerParty.dto.QueryDinnerParty;
import com.mzhotel.sm.dinnerParty.mapper.DinnerPartyMapper;
import com.mzhotel.sm.dinnerParty.service.DinnerPartyService;
import com.mzhotel.sm.documentInfoRelation.service.DocumentInfoRelationService;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import com.mzhotel.sm.util.MyBatisDAO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    public void delete(String id) {
        if(StringUtils.isEmpty(id)){
            return;
        }
        dinnerPartyMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public DinnerParty insert(DinnerParty record) {
        record.setCreatedBy(userInfoService.getCurrUser());
        record.setCreatedDate(new Date());
        int result = dinnerPartyMapper.insert(record);
        if (result == 1) {
            return getOneDinnerParty(record.getId());
        }
        return null;
    }

    @Override
    @Transactional
    public DinnerParty update(DinnerParty record) {
        record.setUpdatedBy(userInfoService.getCurrUser());
        record.setUpdatedDate(new Date());
        int result = dinnerPartyMapper.updateByPrimaryKeySelective(record);
        if (result == 1) {
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
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        return dinnerPartyMapper.selectByPrimaryKey(id);
    }


}
