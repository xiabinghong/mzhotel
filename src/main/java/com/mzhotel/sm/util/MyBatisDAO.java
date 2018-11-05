package com.mzhotel.sm.util;

import com.mzhotel.sm.pageUtil.PageResult;

import java.util.Date;
import java.util.List;

public interface MyBatisDAO<T> {

    public PageResult selectPage(List list, int pageNum, int pageSize);

    /*<T> PageResult<T> selectPageV2(String sqlMapperId, int pageNum, int pageSize,BaseQueryModel baseQueryModel);*/

    Date getCurrmentDate();

    public PageResult<T> queryPage(List<T> list,Integer pageNum,Integer pageSize);
}
