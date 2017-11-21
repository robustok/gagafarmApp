package com.robustok.gagafarm.data.source;

import android.support.annotation.NonNull;

import com.robustok.gagafarm.data.Login;
import com.robustok.gagafarm.data.User;
import com.robustok.gagafarm.login.LoginContract;
import com.robustok.gagafarm.register.RegisterContract;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 * 用户注册数据源接口
 */

public interface UserDataSource {
    //用于Presenter从Model层获取用户数据的回调接口
    public interface GetUserCallback{
        void onUserLoaded(User user);
        void onDataNotAvailable();

    }


    //注入一个LoginPrsenter
    void setLoginPresent(LoginContract.Presenter present);
    //注入一个RegisterPrsenter
    void setRegisterPresenter(RegisterContract.Presenter presenter);

    //保存用户数据
    //add a callback parameters for feedbacking the result to the caller
    void saveUser(User user);



    //通过回调，获取一个指定用户
    void getUser(@NonNull Login login, @NonNull GetUserCallback getUserCallback);

    //获取所有用户的信息
    List<User> getAllUsers();

    //删除用户
    boolean deleteUser(String deleteUser);

    //删除所有用户
    boolean deleteAllUsers();


}
