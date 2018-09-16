package com.mzhotel.util.impl;

import com.mzhotel.util.MyBatisDAO;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.Date;


public class MyBatisDAOImpl extends SqlSessionDaoSupport implements MyBatisDAO {

    public Date getCurrmentDate() {
        return new Date();
    }

    public SqlSession getSqlSessionTemplate() {
        return getSqlSession();
    }

}
