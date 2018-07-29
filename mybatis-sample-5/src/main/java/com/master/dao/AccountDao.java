package com.master.dao;

import com.master.bean.Account;

/**
 * Created by daizhao.
 * User: tony
 * Date: 2018-7-27
 * Time: 17:22
 * info:
 */
public interface AccountDao {

    public Account findAccount(int id);

    public int save(Account account);

    public Account getAccount(int id);
}
