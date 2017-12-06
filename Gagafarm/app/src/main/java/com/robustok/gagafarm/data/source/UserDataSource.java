package com.robustok.gagafarm.data.source;

import android.support.annotation.NonNull;

import com.robustok.gagafarm.data.User;
import com.robustok.gagafarm.data.UserLogin;
import com.robustok.gagafarm.login.LoginContract;
import com.robustok.gagafarm.register.RegisterContract;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 * 用户注册数据源接口
 */

public interface UserDataSource {
    //用于Presenter从Model层获取用户快速注册数据的回调接口
    public interface GetUserLoginCallback{
        void onLoaded(UserLogin userLogin);//加载用户快速注册数据
        void onLoadedAll();//加载所有用户的快速注册数据
        void onDataNotAvailable();//没有找到用户的快速注册数据

    }

    //用于Presenter从Model层获取快速注册的结果
    public interface SaveUserLoginCallback{
        void onSaveOk();//用户的快速注册数据保存成功
        void onSaveFailed();//用户的快速注册数据保存失败
    }

    ////删除用户快速注册数据的回调接口
    public interface DeleteUserLoginCallback{
        void onDeleteOk(UserLogin userLogin); //删除成功
        void onDeleteFailed(UserLogin userLogin);//删除失败
    }


    //注入一个LoginPrsenter
    void setLoginPresent(LoginContract.Presenter presenter);
    //注入一个RegisterPrsenter
    void setRegisterPresenter(RegisterContract.Presenter presenter);

    //保存用户快速注册数据
    //add a callback parameters for feedbacking the result to the caller
    void saveUserLogin(@NonNull UserLogin UserLogin, @NonNull SaveUserLoginCallback saveUserLoginCallback);



    //通过回调，获取一个指定用户快速注册数据
    void getUserLogin(@NonNull UserLogin userLogin, @NonNull GetUserLoginCallback getUserLoginCallback);

    //获取所有用户的快速注册信息
     void getAllUserLogin(GetUserLoginCallback getUserLoginCallback);

    //删除用户快速注册数据
    void deleteUserLogin(String userName, DeleteUserLoginCallback deleteUserLoginCallback);

    //删除所有用户的快速注册数据
    void deleteAllUserLogin(DeleteUserLoginCallback deleteUserLoginCallback);


}
