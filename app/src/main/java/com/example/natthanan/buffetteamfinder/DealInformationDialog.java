package com.example.natthanan.buffetteamfinder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Banned on 10/14/2016.
 */

public class DealInformationDialog extends DialogFragment {

    DealInformationDialog.Communicator communicator;
    TextView available, time, restaurant, branch;

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

        setCancelable(false);

        View view = inflater.inflate(R.layout.information_deal_dialog, null);
        available = (TextView) view.findViewById(R.id.available);
        time = (TextView) view.findViewById(R.id.time);
        restaurant = (TextView) view.findViewById(R.id.restaurant);
        branch = (TextView) view.findViewById(R.id.branch);

        builder.setTitle("Deal Information");
        builder.setView(view)
                .setPositiveButton("Join", null)
                .setNegativeButton("Cancel", null);

        return builder.create();
    }

    @Override
    public void onResume() {
        super.onResume();
        AlertDialog alertDialog = (AlertDialog) getDialog();
        Button okButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOkButtonAction();
            }
        });
    }

    private void performOkButtonAction(){

        communicator.onDialogMessage(available.getText().length(), time.getText().toString(), restaurant.getText().toString(), branch.getText().toString());
        dismiss();
    }

    interface Communicator {
        void onDialogMessage(int Available, String time, String restaurant, String branch);
    }
}
