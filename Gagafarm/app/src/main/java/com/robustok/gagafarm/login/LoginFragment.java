package com.robustok.gagafarm.login;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.robustok.gagafarm.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContract.View {

   //defing a static member for factory method
    public static LoginFragment instance = null;
    private LoginFragment.OnFragmentInteractListener mListener;
    private LoginContract.Presenter mPresenter;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
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
        public void onFragmentInteract(String str);
    }


}
