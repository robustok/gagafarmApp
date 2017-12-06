package com.robustok.gagafarm.data;

/**
 * Created by Administrator on 2017/11/21.
 * 用户的快速登录数据
 */

public class UserLogin {
    private String mUserName;
    private String mPassword;

    public UserLogin(){}
    public UserLogin(String userName, String password){
        mUserName = userName;
        mPassword = password;
    }

    public String  getUserName(){
        return this.mUserName;
    }
    public String getPassword(){
        return this.mPassword;
    }

    public void setUserName(String userName){
        this.mUserName = userName;
    }
    public void setPassword(String password){
        this.mPassword = password;
    }


}
