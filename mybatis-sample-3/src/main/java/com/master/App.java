package com.master;

import com.master.bean.Account;
import com.master.dao.AccountDao;
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

        //applicationContext();

        //applicationContext1();

        applicationContext2();

    }
    /**
    *  @Author daizhao
    *  @Date 2018-7-28 13:10
    *  @Params 
    *  @Return 
    *  @Info  开 启 Spring 的 事 务 处 理 方 式 一 采用AOP配置方式
    */
    public static void applicationContext(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

        Account account = accountDao.findAccount(1);

        System.out.println("account.toString() = " + account.toString());
    }
    
    /**
    *  @Author daizhao
    *  @Date 2018-7-28 13:11
    *  @Params 
    *  @Return 
    *  @Info  开 启 Spring 的 事 务 处 理 方 式 二 使用annotation注解方式配置事务
    */
    public static void applicationContext1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-1.xml");

        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

        Account account = accountDao.findAccount(1);

        System.out.println("account.toString() = " + account.toString());
    }
    
    /**
    *  @Author daizhao
    *  @Date 2018-7-28 13:14
    *  @Params 
    *  @Return 
    *  @Info  将事务由Mybatis管理，不由Spring管理
    */
    public static void applicationContext2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-2.xml");

        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");

        Account account = accountDao.findAccount(1);

        System.out.println("account.toString() = " + account.toString());
    }


}
