package com.robustok.gagafarm.login;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.robustok.gagafarm.R;
import com.robustok.gagafarm.data.UserLogin;
import com.robustok.gagafarm.data.source.UserDataSource;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContract.View {

   //defing a static member for factory method
    public static LoginFragment instance = null;
    private LoginFragment.OnFragmentInteractListener mListener;
    private LoginContract.Presenter mPresenter;
    private TextView mUserName;
    private TextView mPassword;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        Activity activity = getActivity();
        Button btnLogin = (Button)activity.findViewById(R.id.btnLogin);
         mUserName =(TextView)activity.findViewById(R.id.userName);
         mPassword = (TextView)activity.findViewById(R.id.password);

        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                UserLogin Userlogin =new UserLogin();
                Userlogin.setUserName(mUserName.getText().toString());
                Userlogin.setPassword(mPassword.getText().toString());
                mPresenter.login(Userlogin, new UserDataSource.GetUserLoginCallback(){

                    @Override
                    public void onLoaded(UserLogin userLogin) {
                        showLoginResult(userLogin);
                    }

                    @Override
                    public void onLoadedAll() {

                    }

                    @Override
                    public void onDataNotAvailable() {

                    }
                });
            }
        });
    }

    public static LoginFragment newInstance(){
       if(instance == null)
         instance =  new LoginFragment();
        return instance;
    }


    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if(context instanceof OnFragmentInteractListener){
            mListener = (LoginFragment.OnFragmentInteractListener) context;
        }
        else{
            throw new RuntimeException(context.toString()+"must implements OnFragmentInteractionListener");
        }



    }

    //与Activity互动的接口
    public interface OnFragmentInteractListener{
        public void onFragmentInteract(String string);
    }

     //显示登录结果
    public void showLoginResult(UserLogin userLogin){
        if(userLogin == null)
            mUserName.setText("登录失败！");
        else
            mUserName.setText("恭喜，"+userLogin.getUserName()+"登录成功！");



    }
}
