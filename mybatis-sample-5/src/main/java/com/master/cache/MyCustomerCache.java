package com.master.cache;

import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by daizhao.
 * User: tony
 * Date: 2018-7-29
 * Time: 9:34
 * info:
 */
public class MyCustomerCache implements Cache {

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void putObject(Object o, Object o1) {

    }

    @Override
    public Object getObject(Object o) {
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
