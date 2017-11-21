package com.robustok.gagafarm.login;

import android.app.Fragment;
import android.support.annotation.NonNull;

import com.robustok.gagafarm.data.Login;
import com.robustok.gagafarm.data.User;
import com.robustok.gagafarm.data.source.LocalUserDataSource;
import com.robustok.gagafarm.data.source.RemoteUserDataSource;
import com.robustok.gagafarm.data.source.UserDataSource;
import com.robustok.gagafarm.data.source.UserRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Administrator on 2017/11/7.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private static LoginPresenter INSTANCE = null;
    private UserDataSource mUserRepository;
    private LoginContract.View mFragment;

    public LoginPresenter(){}
    public LoginPresenter(@NonNull UserDataSource userRepository,@NonNull Fragment fragment){
        checkNotNull(userRepository);
        checkNotNull(fragment);
        this.mFragment =(LoginContract.View)fragment;
        this.mUserRepository = userRepository;
    }

    @Override
    public void login(Login login) {
        //delivery a object's reference which impliments GetUserCallback interface to mUserRepository,and  get the user's data.
        mUserRepository.getUser(login,new UserDataSource.GetUserCallback(){

            @Override
            public void onUserLoaded(User user) {
                mFragment.showLoginResult(user);
            }

            @Override
            public void onDataNotAvailable() {
                mFragment.showLoginResult(null);
            }
        });

    }




    public static  LoginPresenter newInstance(@NonNull UserDataSource userRepository,@NonNull Fragment fragment){
        if(INSTANCE == null)
            INSTANCE = new LoginPresenter(userRepository,fragment);
        return INSTANCE;
    }
}
