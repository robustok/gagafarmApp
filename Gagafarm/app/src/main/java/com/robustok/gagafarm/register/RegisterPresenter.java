package com.robustok.gagafarm.register;

import android.view.View;

import com.robustok.gagafarm.data.User;
import com.robustok.gagafarm.data.source.RemoteUserDataSource;
import com.robustok.gagafarm.data.source.UserDataSource;

import java.util.List;

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
    public boolean userNameIsAvailable(String userName) {
       // return false;
      if(this.getUserByName(userName)!=null)
          return true;
      else
        return false;
    }

    @Override
    public void saveUser(User user) {
        mUserRepository.saveUser(user);
    }


    @Override
    public List<User> getAllUser() {
       return mUserRepository.getAllUsers();
    }

    @Override
    public User getUserByName(String userName) {
      // User user =  mUserRepository.getUser(userName);
      return null;
    }

    @Override
    public boolean deleteUser(String userName) {
        return false;
    }

    @Override
    public boolean deleteAllUser() {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public void showRegisterResult(String str) {
       //如何判断当前视是激活状态
        this.mRegisterFragment.showRegisterSuccess(str);
    }


}
