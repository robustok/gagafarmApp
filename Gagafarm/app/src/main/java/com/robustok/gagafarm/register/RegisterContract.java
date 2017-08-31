package com.robustok.gagafarm.register;

import com.robustok.gagafarm.data.User;

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
         * 显示注册成功
         */
        void showRegisterSuccess();

    }

    /**
     * presenter层的标准方法
     */
    interface Presenter{

        /**
         * 用户名是否可用，若可用则返回1，不可用返回0；
         * @param userName
         * @return
         */
        int userNameIsAvailable(String userName);

        /**
         * 保存用户的注册数据
         * @param user
         */
        void saveUser(User user);



    }
}
