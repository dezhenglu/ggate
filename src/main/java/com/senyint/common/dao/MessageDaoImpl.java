package com.senyint.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageDaoImpl implements MessageDao {
    
 // mybatis
    @Autowired(required = false)
    protected SqlSession sqlSession;

    public SqlSession getSqlSession() {
        return sqlSession;
    }
    
    @Override
    public List<Map<String, String>> qryNotice() {
        return sqlSession.selectList("message.selectInstantMessage", null);
    }

}
