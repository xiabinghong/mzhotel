package com.mzhotel.sm.util.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mzhotel.sm.pageUtil.PageResult;
import com.mzhotel.sm.util.MyBatisDAO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MyBatisDAOImpl<T> implements MyBatisDAO<T> {

    @Override
    public Date getCurrmentDate() {
        return new Date();
    }

    public PageResult<T> queryPage(List<T> list, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageResult<T>((Page<T>) list);
    }

    /*@Override
    public SqlSession getSqlSessionTemplate(){
        return getSqlSession();
    }*/


    @Override
    public PageResult selectPage(List list, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page page = (Page) list;
        return new PageResult(page);
    }


    /*@Override
    public <T> PageResult<T> selectPageV2(List list, int pageNum, int pageSize, BaseQueryModel baseQueryModel) {
        if (baseQueryModel != null) {
            String orderBy = baseQueryModel.getOrderBy();
            if (StringUtils.trimToNull(orderBy) != null) {
                PageHelper.orderBy(orderBy);
            }
        }
        PageHelper.startPage(pageNum, pageSize);
        Page<T> page = (Page<T>) this.getSqlSessionTemplate().selectList(sqlMapperId, baseQueryModel);
        return new PageResult<T>(page);
    }*/
}
