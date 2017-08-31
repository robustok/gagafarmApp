package com.robustok.gagafarm.data;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/5/26.
 * this bean be used while a guest registers in Gagafarm
 */

public final class User {
    private String mUserName;
    private String mPassword;
    public User(){}

    public User(@NonNull String userName, @Nullable String password) {
        this.mUserName = userName;
        this.mPassword = password;
    }
    public String getUserName(){
        return this.mUserName;
    }
    public String getPassword(){
        return this.mPassword;
    }
}
