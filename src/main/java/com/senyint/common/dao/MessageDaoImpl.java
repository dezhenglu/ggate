package com.senyint.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class MessageDaoImpl implements MessageDao {
    
 // mybatis
//    @Autowired(required = false)
//    protected SqlSession sqlSession;
//
//    public SqlSession getSqlSession() {
//        return sqlSession;
//    }
    
    private SqlSession sqlSession;
    
    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Map<String, String>> qryNotice() {
        return sqlSession.selectList("message.selectNotice");
    }

}
