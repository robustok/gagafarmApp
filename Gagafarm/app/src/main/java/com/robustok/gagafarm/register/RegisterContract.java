package com.robustok.gagafarm.register;

import com.robustok.gagafarm.data.User;
import com.robustok.gagafarm.data.UserLogin;
import com.robustok.gagafarm.data.source.UserDataSource;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 * 规定用户注册的view 和presenter 层的协议
 */

public interface RegisterContract {
    /**
     * view 层的标准方法
     */
    interface View{
        /**
         * 显示注册成功或失败
         */
        void showRegisterSuccess(String okOrNot);

        /**
         * 设置所需要的Presenter
         * @param registerPresenter
         */
        public void setPresenter(RegisterContract.Presenter  registerPresenter );

    }

    /**
     * presenter层的标准方法
     */
    interface Presenter{

        /**
         * 保存用户的快速注册数据
         * @param userLogin
         * @param saveUserLoginCallback
         */
        void saveUserLogin(UserLogin userLogin,
                           UserDataSource.SaveUserLoginCallback saveUserLoginCallback);

        /**
         * 获取所有用户的快速注册数据
         */
        void getAllUserLogin(UserDataSource.GetUserLoginCallback getUserLoginCallback);

        /**
         * 获取指定用户的快速注册数据
         * @param userName 用户名
         */
        void getUserLoginByName(String userName, UserDataSource.GetUserLoginCallback getUserLoginCallback);

    }
}
