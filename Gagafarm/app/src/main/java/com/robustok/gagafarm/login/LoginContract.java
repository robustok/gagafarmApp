package com.robustok.gagafarm.login;

import com.robustok.gagafarm.data.User;

/**
 * Created by Administrator on 2017/11/7.
 */

public interface LoginContract {

    public interface View{
        /**
         * 为该View注入一个presenter
         * @param presenter
         */
        void setPresenter(LoginContract.Presenter presenter);
    }
    public interface Presenter{
        /**
         * 用户登录
         * @param user
         * @return
         */
        boolean login(User user);
    }
}
