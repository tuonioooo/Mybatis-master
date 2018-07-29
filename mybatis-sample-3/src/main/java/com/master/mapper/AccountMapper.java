package com.master.mapper;

import com.master.bean.Account;
import org.apache.ibatis.annotations.Select;

public interface AccountMapper {
  @Select("SELECT * FROM account WHERE id = #{id}")
  Account findAccount(int id);

  @Select("SELECT * FROM account WHERE id = #{id}")
  Account getAccount(String id);
}