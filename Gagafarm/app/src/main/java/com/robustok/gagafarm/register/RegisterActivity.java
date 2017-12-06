package com.robustok.gagafarm.register;


import android.net.Uri;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentTransaction;
//import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.robustok.gagafarm.R;
import com.robustok.gagafarm.Utility.ActivityUtils;
import com.robustok.gagafarm.Utility.Injection;
import com.robustok.gagafarm.data.source.UserRepository;


public class RegisterActivity extends AppCompatActivity implements RegisterFragment.OnFragmentInteractionListener {

    private RegisterFragment mRegisterFragment;
    private RegisterPresenter mRegisterPresenter;
    private UserRepository mUserRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       // Intent intent = getIntent();
        //((TextView)findViewById(R.id.hello)).setText(intent.getStringExtra("name"));

        mRegisterFragment=(RegisterFragment)getFragmentManager().findFragmentById(R.id.registerFrame);
        if(mRegisterFragment==null)
        {
            mRegisterFragment= RegisterFragment.newInstance();

        }

       ActivityUtils.addFragmentToActivity(getFragmentManager(),mRegisterFragment,R.id.registerFrame);

       //以下两行代码将model层、pesenter层与View层联系起来
        mUserRepository = Injection.provideUserRepository(getApplicationContext());
        mRegisterPresenter = new RegisterPresenter(mUserRepository, mRegisterFragment);
        mRegisterFragment.setPresenter(mRegisterPresenter);
        mUserRepository.setRegisterPresenter(mRegisterPresenter);
    }




    @Override
    public void onFragmentInteraction(String registerOkOrNot) {
        getFragmentManager()
                .beginTransaction().addToBackStack(null)
                .replace(R.id.registerFrame,
              RegisterResultFragment.newInstance(registerOkOrNot,null)).commit();

    }


}
