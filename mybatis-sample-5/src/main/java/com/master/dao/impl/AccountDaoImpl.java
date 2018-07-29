package com.master.dao.impl;

import com.master.bean.Account;
import com.master.dao.AccountDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by daizhao.
 * User: tony
 * Date: 2018-7-27
 * Time: 17:23
 * info:
 */
@Service("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public Account findAccount(int id) {
        return (Account) sqlSessionTemplate.selectOne("AccountMapper.findAccount", id);
    }

    public int save(Account account) {
        return sqlSessionTemplate.insert("AccountMapper.insert", account);
    }

    public Account getAccount(int id) {
        return (Account) sqlSessionTemplate.selectOne("AccountOfMapper.getAccount", id);
    }
}
