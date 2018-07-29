package com.master;

import com.master.bean.Account;
import com.master.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by daizhao.
 * User: tony
 * Date: 2018-7-26
 * Time: 17:19
 * info: 用XML构建SqlSessionFactory获取SqlSession，进行持久化操作
 */
public class CreateSqlSessionByXML {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        xmlMapper(sqlSessionFactory);

    }

    public static void xmlMapper(SqlSessionFactory sqlSessionFactory){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Account account = (Account) session.selectOne("mapper.AccountMapper.findAccount", 1);
        } finally {
            session.close();
        }
    }

    public static void interfaceMapper(SqlSessionFactory sqlSessionFactory){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            AccountMapper mapper = session.getMapper(AccountMapper.class);
            Account account = mapper.findAccount(1);
        } finally {
            session.close();
        }
    }
}
