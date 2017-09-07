package com.robustok.gagafarm.register;

import com.robustok.gagafarm.data.User;

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
         * 用户名是否可用，若可用则返回1，不可用返回0；
         * @param userName
         * @return
         */
        boolean userNameIsAvailable(String userName);

        /**
         * 保存用户的注册数据
         * @param user
         */
        void saveUser(User user);

        /**
         * 获取所有用户
         */
        List<User> getAllUser();

        /**
         * 获取指定用户
         * @param userName 用户名
         */
        User getUserByName(String userName);

        /**
         * 删除指定用户
         * @param userName
         * @return
         */
        boolean deleteUser(String userName);

        /**
         * 删除所有用户
         * @return
         */
        boolean deleteAllUser();

        /**
         * 更新用户数据
         * @param user
         * @return
         */
        boolean updateUser(User user);

    }
}
