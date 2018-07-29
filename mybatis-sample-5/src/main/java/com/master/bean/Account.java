package com.master.bean;

import lombok.*;

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
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private int id;

    private String name;

    private double money;
}
