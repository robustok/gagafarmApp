package com.robustok.gagafarm.data.source;

import com.robustok.gagafarm.data.User;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 * 用户注册数据源接口
 */

public interface UserDataSource {
    //保存用户数据
    void saveUser(User user);



    //获取一个指定用户
    User getUser(String userName);

    //获取所有用户的信息
    List<User> getAllUsers();

    //删除用户
    boolean deleteUser(String deleteUser);

    //删除所有用户
    boolean deleteAllUsers();


}
