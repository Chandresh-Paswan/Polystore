package com.example.android.polystore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ProducerList extends Fragment {

    private List<ProducerSetter> producerList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProducerAdapter mAdapter;
    static Integer[] drawableArray = {R.drawable.chandu};

    public ProducerList() {
        // Required empty public constructor
    }

    public static ProducerList newInstance(String param1, String param2) {
        ProducerList fragment = new ProducerList();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_producer_list, container, false);

        recyclerView = (RecyclerView) rootview.findViewById(R.id.recycler_view);

        mAdapter = new ProducerAdapter(producerList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareProducerData();
        return rootview;
    }

    private void prepareProducerData() {
        ProducerSetter movie = new ProducerSetter("Chandresh store", "Reg. Date -12 Dec,2018","Mob. Number-8951748991",drawableArray[0]);
        producerList.add(movie);

        movie = new ProducerSetter("Prabhakar Store", "Reg. Date -12 Dec,2018","Mob. Number-8951748991",drawableArray[0] );
        producerList.add(movie);

        movie = new ProducerSetter("Praveen Store", "Reg. Date -12 Dec,2018","Mob. Number-8951748991",drawableArray[0]);
        producerList.add(movie);

        movie = new ProducerSetter("Devender Store", "Reg. Date -12 Dec,2018","Mob. Number-8951748991",drawableArray[0]);
        producerList.add(movie);

        movie = new ProducerSetter("Karishma Store","Reg. Date -12 Dec,2018","Mob. Number-8951748991",drawableArray[0]);
        producerList.add(movie);


        mAdapter.notifyDataSetChanged();
    }


}
