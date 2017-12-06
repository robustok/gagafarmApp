package com.robustok.gagafarm.register;

import com.robustok.gagafarm.data.UserLogin;
import com.robustok.gagafarm.data.source.UserDataSource;

/**
 * Created by Administrator on 2017/6/29.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private UserDataSource mUserRepository;
    private RegisterContract.View mRegisterFragment;
    public RegisterPresenter(){}
    public RegisterPresenter(UserDataSource userRepository, RegisterContract.View registerView){
        this.mUserRepository = userRepository;
        this.mRegisterFragment = registerView;
   }

    @Override
    public void saveUserLogin(UserLogin userLogin, UserDataSource.SaveUserLoginCallback saveUserLoginCallback) {
        mUserRepository.saveUserLogin(userLogin,saveUserLoginCallback);
    }

    @Override
    public void getAllUserLogin(UserDataSource.GetUserLoginCallback getUserLoginCallback) {
        return;
    }



    @Override
    public void getUserLoginByName(String userName, UserDataSource.GetUserLoginCallback getUserLoginCallback) {
      // User user =  mUserRepository.getUser(userName);
      return ;
    }


}
