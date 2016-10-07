package com.example.natthanan.buffetteamfinder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tastomy on 10/8/2016 AD.
 */

public class DealRecyclerAdapter extends RecyclerView.Adapter<DealRecyclerAdapter.ViewHolder> {
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

        public ViewHolder(View itemView) {
            super(itemView);

            restaurantName = (TextView) itemView.findViewById(R.id.restaurantName);
            distance = (TextView) itemView.findViewById(R.id.distance);
            name = (TextView) itemView.findViewById(R.id.name);
            time = (TextView) itemView.findViewById(R.id.time);

//            promotionImage = (ImageView) itemView.findViewById(R.id.promotionImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), ChooseDealActivity.class);
                    view.getContext().startActivity(intent);
                }
            });
        }
    }
}
