package com.example.android.polystore;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by chandresh on 3/25/18.
 */

public class ProducerAdapter extends RecyclerView.Adapter<ProducerAdapter.MyViewHolder> {

    private List<ProducerSetter> producerList;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mshopName, mRegistrationDate,mMobileNumber;
        public ImageView img;

        public MyViewHolder(View view) {
            super(view);
            mshopName = (TextView) view.findViewById(R.id.shop_name);
            mRegistrationDate = (TextView) view.findViewById(R.id.registration_date);
            mMobileNumber = (TextView) view.findViewById(R.id.mobile_number);
            img = (ImageView) view.findViewById(R.id.producer_image);
        }
    }

    public ProducerAdapter(List<ProducerSetter> producerList) {
        this.producerList = producerList;
    }

    @Override
    public ProducerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.producer_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProducerAdapter.MyViewHolder holder, int position) {

        ProducerSetter producerSetter = producerList.get(position);
        holder.mshopName.setText(producerSetter.getStore_name());
        holder.mRegistrationDate.setText(producerSetter.getRegistration_date());
        holder.mMobileNumber.setText(producerSetter.getMobile_number());
        holder.img.setImageResource(producerSetter.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), NavigationHome.class);
                /*intent.putExtra("land")*/
                 view.getContext().startActivity(intent);
                //((Activity) view.getContext()).startActivityForResult(intent,1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return producerList.size();
    }
}
