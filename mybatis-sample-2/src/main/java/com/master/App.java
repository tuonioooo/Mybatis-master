package com.master;

import com.master.bean.Account;
import com.master.dao.AccountDao;
import com.master.dao.impl.AccountDaoImpl;
import com.master.mapper.AccountMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by daizhao.
 * User: tony
 * Date: 2018-7-27
 * Time: 16:33
 * info:
 */
public class App {

    public static void main(String[] args) {


        //applicationContext1();
        //applicationContext2();
        //applicationContext3();
        applicationContext4();

    }

    public static void applicationContext1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-1.xml");

        AccountMapper accountMapper = (AccountMapper) applicationContext.getBean("accountMapper");

        Account account = accountMapper.findAccount(1);

        System.out.println("account.toString() = " + account.toString());

        Account newAccount = accountMapper.getAccount("1=1");

        System.out.println("newAccount.toString() = " + newAccount.toString());
    }

    public static void applicationContext2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-2.xml");

        SqlSession sqlSession = (SqlSession) applicationContext.getBean("sqlSession");

        Account account = (Account)sqlSession.selectOne("mapper.AccountMapper.findAccount", 1);

        System.out.println("account.toString() = " + account.toString());
    }

    public static void applicationContext3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-3.xml");

        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

        Account account = accountDao.findAccount(1);

        System.out.println("account.toString() = " + account.toString());
    }

    public static void applicationContext4(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-4.xml");

        AccountMapper accountMapper = (AccountMapper) applicationContext.getBean("accountMapper");

        Account account = accountMapper.findAccount(1);

        System.out.println("account.toString() = " + account.toString());

        Account newAccount = accountMapper.getAccount("1");

        System.out.println("newAccount.toString() = " + newAccount.toString());
    }
}
