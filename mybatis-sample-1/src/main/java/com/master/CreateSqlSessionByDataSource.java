package com.master;

import com.master.bean.Account;
import com.master.mapper.AccountMapper;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by daizhao.
 * User: tony
 * Date: 2018-7-26
 * Time: 17:19
 * info: 用接口映射实现构建SqlSessionFactory获取SqlSession，进行持久化操作
 */
public class CreateSqlSessionByDataSource {

    public static void main(String[] args) throws IOException, SQLException {

        DataSource dataSource = createDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(AccountMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        interfaceMapper(sqlSessionFactory);

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
            System.out.println("account.toString() = " + account.toString());
        } finally {
            session.close();
        }
    }



    public static DataSource createDataSource() throws SQLException {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/hua");
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setInitialSize(50);
        ds.setMaxActive(100);
        ds.setMaxIdle(30);
        ds.setMaxWait(10000);
        // 关闭数据源连接
        //ds.close();
        return ds;
    }
}
