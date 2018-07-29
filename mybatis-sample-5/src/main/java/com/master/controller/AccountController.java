package com.master.controller;

import com.master.bean.Account;
import com.master.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daizhao.
 * User: tony
 * Date: 2018-7-28
 * Time: 22:41
 * info:
 */
@RestController
public class AccountController {

    @Autowired
    private AccountDao accountDao;

    @RequestMapping("/findAccount")
    public String findAccount(){
        return accountDao.findAccount(1).toString();
    }

    @RequestMapping("/getAccount")
    public String getAccount(){
        return accountDao.getAccount(1).toString();
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(){
        Account account = new Account(4,"allen", 2000);
        return accountDao.save(account) + "";
    }
}
