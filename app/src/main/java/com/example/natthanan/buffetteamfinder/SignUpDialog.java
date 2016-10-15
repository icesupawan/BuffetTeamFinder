package com.example.natthanan.buffetteamfinder;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
public class SignUpDialog extends DialogFragment {
    SignUpDialog.Communicator communicator;
    EditText name, password, confirmPassword, email;
    Button sign_up_button;
    TextView go_login;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        setCancelable(true);

        View view = inflater.inflate(R.layout.sign_up_dialog, null);
        name = (EditText) view.findViewById(R.id.name);
        password = (EditText) view.findViewById(R.id.password);
        confirmPassword = (EditText) view.findViewById(R.id.confirmPassword);
        email = (EditText) view.findViewById(R.id.email);
        sign_up_button = (Button) view.findViewById(R.id.sign_up_button);
        go_login = (TextView) view.findViewById(R.id.already_sign_up);

        builder.setView(view);

        return builder.create();
    }

    @Override
    public void onResume() {
        super.onResume();
        AlertDialog alertDialog = (AlertDialog) getDialog();
        sign_up_button = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp(name.getText().toString(), password.getText().toString(), confirmPassword.getText().toString(), email.getText().toString());
            }
        });
        go_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLogin();
                dismiss();
            }
        });
    }

    private void signUp(String name, String password, String confirmPassword, String email){
        if(name == null || password == null || confirmPassword == null || email == null){
            Toast.makeText(getContext(), "Please fill all the blanks.", Toast.LENGTH_SHORT);
        }else if(password.equals(confirmPassword) && name != null && email != null){
            Toast.makeText(getContext(), "Password mismatch.", Toast.LENGTH_SHORT);
        }else{
            Toast.makeText(getContext(), "HEY!! UNDER MAINTENANCE", Toast.LENGTH_SHORT);
        }
    }

    private void goLogin(){
        LoginDialog loginDialog = new LoginDialog();
        FragmentManager fm = getFragmentManager();
        loginDialog.show(fm, "HEY");
    }

    interface Communicator{
        void onDialogMessage(String username, String password, String confirmPassword, String email);
    }
}
