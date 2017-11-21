package com.robustok.gagafarm.data;

/**
 * Created by Administrator on 2017/11/21.
 */

public class Login {
    private String mUserName;
    private String mPassword;

    public Login(){}

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
