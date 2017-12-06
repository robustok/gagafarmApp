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
    private String mEmail;
    private String mMobilePhone;

    public User(){}
    public String getUserName(){return this.mUserName;}
    public String getPassword(){return this.mPassword;}
    public String getEmail(){return this.mEmail;}
    public String getMobilePhone(){return this.mMobilePhone;}

    public void setUserName(String userName){this.mUserName = userName;}
    public void setPassword(String password){this.mPassword = password;}
    public void setEmail(String email){this.mEmail = email;}
    public void setmMobilePhone(String mobilePhone){this.mMobilePhone = mobilePhone;}
}
