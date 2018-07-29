package com.master.dao.impl;

import com.master.bean.Account;
import com.master.dao.AccountDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by daizhao.
 * User: tony
 * Date: 2018-7-27
 * Time: 17:23
 * info:
 */
@Transactional
public class AccountDaoImpl extends SqlSessionDaoSupport implements AccountDao {

    public Account findAccount(int id) {
        return (Account) getSqlSession().selectOne("mapper.AccountMapper.findAccount", id);
    }


}
