package com.mzhotel.util;

import org.apache.ibatis.session.SqlSession;

import java.util.Date;

public interface MyBatisDAO {

    SqlSession getSqlSessionTemplate();

    Date getCurrmentDate();
}
