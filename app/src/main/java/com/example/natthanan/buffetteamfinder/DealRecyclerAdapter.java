package com.example.natthanan.buffetteamfinder;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Tastomy on 10/8/2016 AD.
 */

public class DealRecyclerAdapter extends RecyclerView.Adapter<DealRecyclerAdapter.ViewHolder> {

    Context context;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.deal_recycler_child, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView restaurantName;
        TextView distance;
        TextView name;
        TextView time;
        ImageView promotionImage;
        Button joinDeal;

        public ViewHolder(final View itemView) {
            super(itemView);

            restaurantName = (TextView) itemView.findViewById(R.id.restaurantName);
            distance = (TextView) itemView.findViewById(R.id.distance);
            name = (TextView) itemView.findViewById(R.id.name);
            time = (TextView) itemView.findViewById(R.id.time);
            joinDeal = (Button) itemView.findViewById(R.id.joinDeal);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    CreateDealInformationDialog createDealInformationDialog = new CreateDealInformationDialog();
//                    //createDealInformationDialog.show(, "dialog");
//                }
//            });
            joinDeal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LoginDialog loginDialog = new LoginDialog();
                    FragmentManager fm = ((FragmentActivity)itemView.getContext()).getSupportFragmentManager();
                    loginDialog.show(fm, "test");
                }
            });

//            promotionImage = (ImageView) itemView.findViewById(R.id.promotionImage);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(view.getContext(), ChooseDealActivity.class);
//                    view.getContext().startActivity(intent);
//                }
//            });
        }
//        @Override
//        public void onClick(View v){
//            DialogFragment dialogFragment = new DialogFragment();
//            FragmentManager fm = get
//            dialogFragment.show(fm, "tag");
////            DealInformationDialog dialog = DealInformationDialog.newInstance();
////            dialog.show(((Activity) context).getSupportFragmentManager(), "Title");
//            Toast.makeText(v.getContext(), "ITEM PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
//        }
    }
}
