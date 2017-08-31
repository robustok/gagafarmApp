package com.robustok.gagafarm.data.source;

import com.robustok.gagafarm.data.User;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 * 用户注册数据源
 */

public class UserRepository implements UserDataSource{
    @Override
    public void savaUser(User user) {

    }

    @Override
    public User getUser(String getUser) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(String deleteUser) {

    }

    @Override
    public void deleteAllUsers() {

    }
}
