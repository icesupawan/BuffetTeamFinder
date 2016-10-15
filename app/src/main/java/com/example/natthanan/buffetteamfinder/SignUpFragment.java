package com.example.natthanan.buffetteamfinder;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {
    EditText name, password, confirmPassword, email;
    Button sign_up_button;
    TextView go_login;

    public SignUpFragment(){

    }

    public SignUpFragment newInstance(){
        SignUpFragment signUpFragment = new SignUpFragment();
        return signUpFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        name = (EditText) view.findViewById(R.id.name);
        password = (EditText) view.findViewById(R.id.password);
        confirmPassword = (EditText) view.findViewById(R.id.confirmPassword);
        email = (EditText) view.findViewById(R.id.email);
        sign_up_button = (Button) view.findViewById(R.id.sign_up_button);
        go_login = (TextView) view.findViewById(R.id.already_sign_up);
        go_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLogin();
            }
        });

        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp(view, name.getText().toString(), password.getText().toString(), confirmPassword.getText().toString(), email.getText().toString());
            }
        });

        return view;
    }


    private void signUp(View v, String name, String password, String confirmPassword, String email){
        if(name == null || password == null || confirmPassword == null || email == null){
            Toast.makeText(v.getContext(), "Please fill all the blanks.", Toast.LENGTH_SHORT);
        }else if(password.equals(confirmPassword) && name != null && email != null){
            Toast.makeText(v.getContext(), "Password mismatch.", Toast.LENGTH_SHORT);
        }else{
            Toast.makeText(v.getContext(), "HEY!! UNDER MAINTENANCE", Toast.LENGTH_SHORT);
        }
    }

    private void goLogin(){
        LoginFragment loginFragment = new LoginFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.login_fragment_container, loginFragment);
        transaction.remove(this);
//        transaction.addToBackStack(null);
        transaction.commit();
    }
}
