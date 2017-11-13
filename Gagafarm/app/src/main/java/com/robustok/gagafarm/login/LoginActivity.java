package com.robustok.gagafarm.login;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.robustok.gagafarm.R;
import com.robustok.gagafarm.Utility.ActivityUtils;
import com.robustok.gagafarm.Utility.Injection;
import com.robustok.gagafarm.data.source.UserRepository;

public class LoginActivity extends Activity implements LoginFragment.OnFragmentInteractListener {
   //define a String for Log while debug codes
    private final String TAG = "LoginActivity";

    LoginFragment mLoginFragment;
    LoginPresenter mLoginPresenter;
    UserRepository mUserRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //loading LoginFragment
        mLoginFragment = (LoginFragment)getFragmentManager().findFragmentById(R.id.registerFrame);
        if(mLoginFragment == null){
            mLoginFragment = LoginFragment.newInstance();
        }
        ActivityUtils.addFragmentToActivity(getFragmentManager(),mLoginFragment,R.id.loginFrame);

        //建立model,presenter,view三层间的联系
        UserRepository userRepository = Injection.provideUserRepository(getApplicationContext());
        mLoginPresenter = LoginPresenter.newInstance(userRepository,mLoginFragment);
        mLoginFragment.setPresenter(mLoginPresenter);
        mUserRepository.setLoginPresent(mLoginPresenter);
    }


    @Override
    public void onFragmentInteract(String str) {

    }
}
