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
    DinnerPartyMapper DinnerPartyMapper;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    MyBatisDAO<DinnerParty> myBatisDAO;

    @Autowired
    DocumentInfoRelationService documentInfoRelationService;

    private static final String mapper = "DinnerPartyMapper";

    
    @Override
    @Transactional
    public int deleteByPrimaryKey(String id){
        return DinnerPartyMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insert(DinnerParty record){
        return DinnerPartyMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(DinnerParty record){
        return DinnerPartyMapper.insertSelective(record);
    }

    @Override
    public DinnerParty selectByPrimaryKey(String id){
        return DinnerPartyMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int updateByPrimaryKeySelective(DinnerParty record){
        return DinnerPartyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(DinnerParty record){
        return DinnerPartyMapper.updateByPrimaryKey(record);
    }
    @Override
    public List<DinnerParty> getDinnerPartyList(QueryDinnerParty queryDinnerParty) {
        return DinnerPartyMapper.getDinnerParty(queryDinnerParty);
    }

    @Override
    public PageResult<DinnerParty> getDinnerParty(QueryDinnerParty queryDinnerParty) {
        List<DinnerParty> DinnerPartyList = getDinnerPartyList(queryDinnerParty);
        return myBatisDAO.queryPage(DinnerPartyList,queryDinnerParty.getPageNum(), queryDinnerParty.getPageSize());
    }

    @Override
    public DinnerParty getOneDinnerParty(String id) {
        if (id == null) {
            return null;
        }
        return DinnerPartyMapper.selectByPrimaryKey(id);
    }


}
