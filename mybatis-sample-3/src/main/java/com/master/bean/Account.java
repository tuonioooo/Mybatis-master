package com.master.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by daizhao.
 * User: tony
 * Date: 2018-7-26
 * Time: 17:06
 * info:
 */
@Setter
@Getter
@ToString
public class Account {

    private int id;

    private String name;

    private double money;
}
