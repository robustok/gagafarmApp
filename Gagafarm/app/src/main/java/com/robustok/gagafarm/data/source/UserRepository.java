package com.robustok.gagafarm.data.source;

import com.robustok.gagafarm.data.User;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/18.
 */

public class UserRepository implements UserDataSource {

    public static UserRepository INSTANCE = null;
    private final  UserDataSource mLocalUserDataSource;
    private final UserDataSource mRemoteUserDataSource;


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
    public void saveUser(User user) {
        mRemoteUserDataSource.saveUser(user);
         /*
        mLocalUserDataSource.saveUser(user);
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
