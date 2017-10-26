package com.robustok.gagafarm.register;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.robustok.gagafarm.R;
import com.robustok.gagafarm.data.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements RegisterContract.View {

    private RegisterContract.Presenter mRegisterPresenter;
    private TextView mUserName;
    private TextView mPassword;
    private OnFragmentInteractionListener  mListener;
    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_register, container, false);
        mUserName = (TextView)root.findViewById(R.id.userName);
        mPassword = (TextView)root.findViewById(R.id.password);
        return root;
    }
   @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

      // String userName = getActivity().findViewById(R.id.userName).toString();
       Button btnSubmit = (Button)getActivity().findViewById(R.id.btn_regist);
       btnSubmit.setOnClickListener(new View.OnClickListener(){
           public void onClick(View view){

                    User user =new User(mUserName.getText().toString(),mPassword.getText().toString());
                    mRegisterPresenter.saveUser(user);
           }
       });
    }
    @Override
    public void showRegisterSuccess(String okOrNot) {

        mListener.onFragmentInteraction(okOrNot);

    }

    //return a instance using factory pattern
    public static RegisterFragment newInstance(){
        return new RegisterFragment();
    }

    public void setPresenter(RegisterContract.Presenter  registerPresenter ){
        this.mRegisterPresenter = registerPresenter;
    }

    public interface OnFragmentInteractionListener{
        void onFragmentInteraction(String registerOkOrNot);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
