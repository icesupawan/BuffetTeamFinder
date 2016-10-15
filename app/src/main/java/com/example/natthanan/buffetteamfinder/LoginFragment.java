package com.example.natthanan.buffetteamfinder;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Banned on 10/15/2016.
 */

public class LoginFragment extends Fragment {
    private static boolean LOGINFLAG;
    TextView forgot, sign_up;
    EditText email, password;
    Button sign_in;

    public LoginFragment(){

    }

    public static LoginFragment newInstance(){
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        forgot = (TextView) rootView.findViewById(R.id.forgot);
        sign_up = (TextView) rootView.findViewById(R.id.sign_up);
        email = (EditText) rootView.findViewById(R.id.email);
        password = (EditText) rootView.findViewById(R.id.password);
        sign_in = (Button) rootView.findViewById(R.id.sign_in);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(email.getText().toString(), password.getText().toString());
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goForgot(v);
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goSignUp(v);
            }
        });

        return rootView;
    }


    private void signIn(String email, String password){
        // INPUT CODE HERE
    }

    private void goSignUp(View view){
        Fragment signUpFragment = new SignUpFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.login_fragment_container, signUpFragment);
//        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void goForgot(View view){
        Fragment forgotFragment = new ForgotFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.login_fragment_container, forgotFragment);
        transaction.remove(this);
//        transaction.addToBackStack(null);
        transaction.commit();
    }

    public static boolean getLogInFlag(){
        return LOGINFLAG;
    }
}
