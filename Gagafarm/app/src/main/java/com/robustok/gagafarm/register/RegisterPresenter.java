package com.robustok.gagafarm.register;

import android.util.Log;

import com.robustok.gagafarm.data.User;
import com.robustok.gagafarm.data.source.LocalUserDataSource;
import com.robustok.gagafarm.data.source.UserRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private UserRepository mLocalUserDataSource;
    private RegisterContract.View mRegisterFragment;
    public RegisterPresenter(){}
    public RegisterPresenter(UserRepository userRepository,RegisterContract.View registerView){
        this.mLocalUserDataSource = userRepository;
        this.mRegisterFragment = registerView;
   }

    @Override
    public boolean userNameIsAvailable(String userName) {
        return false;
    }

    @Override
    public void saveUser(User user) {
       if(mLocalUserDataSource.savaUser(user)){
           mRegisterFragment.showRegisterSuccess("恭喜，注册成功!");
       }
        else
           mRegisterFragment.showRegisterSuccess("对不起，注册失败！");
    }

    @Override
    public List<User> getAllUser() {
       return mLocalUserDataSource.getAllUsers();
    }

    @Override
    public User getUserByName(String userName) {
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
}
