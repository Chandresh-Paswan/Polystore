package com.example.android.polystore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CreateOrder extends Fragment {

    public CreateOrder() {
        // Required empty public constructor
    }

    public static CreateOrder newInstance(String param1, String param2) {
        CreateOrder fragment = new CreateOrder();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_order, container, false);
    }

}
