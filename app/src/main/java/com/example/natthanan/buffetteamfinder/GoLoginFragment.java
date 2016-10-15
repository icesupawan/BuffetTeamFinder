package com.example.natthanan.buffetteamfinder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class GoLoginFragment extends Fragment {
    Button goLogin;
    public static GoLoginFragment newInstance() {
        GoLoginFragment fragment = new GoLoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_go_login, container, false);
        goLogin = (Button) view.findViewById(R.id.gologinbutton);
        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), LoginHomeActivity.class);
                view.getContext().startActivity(intent);
            }
        });
        return view;
    }
}
