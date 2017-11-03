package com.robustok.gagafarm.register;


import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.robustok.gagafarm.R;
import com.robustok.gagafarm.Utility.ActivityUtils;
import com.robustok.gagafarm.Utility.Injection;
import com.robustok.gagafarm.data.User;
import com.robustok.gagafarm.data.source.LocalUserDataSource;
import com.robustok.gagafarm.register.RegisterResultFragment;


public class RegisterActivity extends AppCompatActivity implements RegisterResultFragment.OnFragmentInteractionListener,RegisterFragment.OnFragmentInteractionListener {

    private RegisterPresenter mRegisterPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       // Intent intent = getIntent();
        //((TextView)findViewById(R.id.hello)).setText(intent.getStringExtra("name"));

        RegisterFragment registerFragment=(RegisterFragment)getFragmentManager().findFragmentById(R.id.contentFrame);
        if(registerFragment==null)
        {
           registerFragment= RegisterFragment.newInstance();

        }

       ActivityUtils.addFragmentToActivity(getFragmentManager(),registerFragment,R.id.contentFrame);

       //以下两行代码将pesenter层与View层联系起来
        mRegisterPresenter = new RegisterPresenter(Injection.provideUserRepository(getApplicationContext(),registerFragment), registerFragment);
        registerFragment.setPresenter(mRegisterPresenter);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(this,"交流,角楼",Toast.LENGTH_LONG).show();
    }


    @Override
    public void onFragmentInteraction(String registerOkOrNot) {
      //  Toast.makeText(this,"交流,角楼"+"user",Toast.LENGTH_LONG).show();
       // Fragment f = (Fragment) RegisterFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null) .replace(R.id.contentFrame,
              RegisterResultFragment.newInstance(registerOkOrNot,null)).commit();

    }

   /* public void showResult(){
        RegisterResultFragment registerResultFragment = (RegisterResultFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if(registerResultFragment == null){
            registerResultFragment = RegisterResultFragment.newInstance("string1","string2");
        }
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),registerResultFragment,R.id.contentFrame);
    }
    */
}
