package com.robustok.gagafarm.data.source;

import com.robustok.gagafarm.data.User;
import com.robustok.gagafarm.login.LoginContract;
import com.robustok.gagafarm.register.RegisterContract;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/18.
 */

public class UserRepository implements UserDataSource {

    public static UserRepository INSTANCE = null;
    private final  UserDataSource mLocalUserDataSource;
    private final UserDataSource mRemoteUserDataSource;
    private RegisterContract.Presenter mRegisterPresenter;
    private LoginContract.Presenter mLoginPresent;


    private UserRepository(UserDataSource remoteUserDataSource,UserDataSource localUserDataSource){
        mLocalUserDataSource = localUserDataSource;
        mRemoteUserDataSource = remoteUserDataSource;
    }
    Map<String,User> mCatchedUsers;

    public static UserRepository getInstance(UserDataSource localUserDataSource,UserDataSource remoteUserDataSource){
        if(INSTANCE == null){
            INSTANCE =new  UserRepository(localUserDataSource,remoteUserDataSource);
            return INSTANCE;
        }
        return INSTANCE;

    }

    @Override
    public void setLoginPresent(LoginContract.Presenter present) {
        this.mLoginPresent = present;


    }

    @Override
    public void setRegisterPresenter(RegisterContract.Presenter presenter) {
        this.mRegisterPresenter = presenter;
        //为本地和远程数据源分别注入presenter
        mLocalUserDataSource.setRegisterPresenter(this.mRegisterPresenter);
        mRemoteUserDataSource.setRegisterPresenter(this.mRegisterPresenter);
    }

    @Override
    public void saveUser(User user) {
       //保存到远程
        mRemoteUserDataSource.saveUser(user);
/*
        //保存到本地DB
        mLocalUserDataSource.saveUser(user);

        //保存到缓存
        if(mCatchedUsers==null) {
            mCatchedUsers = new LinkedHashMap<>();
        }
        mCatchedUsers.put(user.getUserName(),user);
*/

    }

    @Override
    public User getUser(String userName) {
       return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public boolean deleteUser(String deleteUser) {
        return false;
    }

    @Override
    public boolean deleteAllUsers() {
        return false;
    }
}
