package com.robustok.gagafarm.login;

import com.robustok.gagafarm.data.User;
import com.robustok.gagafarm.data.UserLogin;
import com.robustok.gagafarm.data.source.UserDataSource;

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
        void showLoginResult(UserLogin userLogin);
    }
    public interface Presenter{
        /**
         * 用户登录
         * @param userLogin
         * @param getUserLoginCallback
         * @return
         */
        void login(UserLogin userLogin, UserDataSource.GetUserLoginCallback getUserLoginCallback);

    }
}
