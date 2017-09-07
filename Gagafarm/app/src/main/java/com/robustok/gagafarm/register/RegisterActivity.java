package com.robustok.gagafarm.register;


import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.robustok.gagafarm.R;
import com.robustok.gagafarm.Utility.ActivityUtils;
import com.robustok.gagafarm.Utility.Injection;
import com.robustok.gagafarm.data.source.LocalUserDataSource;

public class RegisterActivity extends AppCompatActivity {

    private RegisterPresenter mRegisterPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       // Intent intent = getIntent();
        //((TextView)findViewById(R.id.hello)).setText(intent.getStringExtra("name"));

        RegisterFragment registerFragment=(RegisterFragment)getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if(registerFragment==null)
        {
            registerFragment= RegisterFragment.newInstance();

        }
      /**
       FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.replace(R.id.contentFrame,registerFragment);
        transaction.commit();
**/
       ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),registerFragment,R.id.contentFrame);

        mRegisterPresenter = new RegisterPresenter(Injection.provideUserRepository(getApplicationContext()), registerFragment);

        registerFragment.setPresenter(mRegisterPresenter);
    }
}
