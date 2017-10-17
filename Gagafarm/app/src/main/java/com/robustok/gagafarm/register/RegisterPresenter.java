package com.robustok.gagafarm.register;

import com.robustok.gagafarm.data.User;
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
        return false;
    }

    @Override
    public void saveUser(User user) {
        mUserRepository.saveUser(user);
        if (this.getUserByName(user.getUserName()) == null) {
            mRegisterFragment.showRegisterSuccess(user.getUserName());
        }
    }


    @Override
    public List<User> getAllUser() {
       return mUserRepository.getAllUsers();
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
