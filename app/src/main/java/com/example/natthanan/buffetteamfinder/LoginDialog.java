package com.example.natthanan.buffetteamfinder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Banned on 10/15/2016.
 */

public class LoginDialog extends DialogFragment {
    LoginDialog.Communicator communicator;
    TextView forgot, sign_up;
    EditText email, password;
    Button sign_in;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        communicator = (Communicator) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        setCancelable(true);

        View view = inflater.inflate(R.layout.login_dialog, null);
        forgot = (TextView) view.findViewById(R.id.forgot);
        sign_up = (TextView) view.findViewById(R.id.sign_up);
        email = (EditText) view.findViewById(R.id.email);
        password = (EditText) view.findViewById(R.id.password);
        sign_in = (Button) view.findViewById(R.id.sign_in);

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goSignUp();
                dismiss();
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "testforgot", Toast.LENGTH_SHORT);
            }
        });


        builder.setView(view);

        return builder.create();
    }

    @Override
    public void onResume() {
        super.onResume();
        AlertDialog alertDialog = (AlertDialog) getDialog();
        sign_in = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(email.getText().toString(), password.getText().toString());
            }
        });
    }

    private void signIn(String email, String password){
        // INPUT CODE HERE
    }

    private void goSignUp(){
        SignUpDialog signUpDialog = new SignUpDialog();
        FragmentManager fm = getFragmentManager();
        signUpDialog.show(fm, "Test");
    }

    private void forgot(View v){

    }

    interface Communicator {
        void onDialogMessage(String email, String password);
    }
}
