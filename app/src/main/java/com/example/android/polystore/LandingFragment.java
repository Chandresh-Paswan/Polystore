package com.example.android.polystore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;


public class LandingFragment extends Fragment {

   TextView mUserName,mGender,mRegistrationDate;
   ImageView mUserImage;

    public LandingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_landing2, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        mUserImage=(ImageView)rootview.findViewById(R.id.landing_image);
        mUserName = (TextView) rootview.findViewById(R.id.user_name);
        mGender = (TextView) rootview.findViewById(R.id.gender);
        mRegistrationDate=(TextView)rootview.findViewById(R.id.user_reg);

        TabHost host = (TabHost)rootview.findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Profile");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Order");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Payment");
        host.addTab(spec);


        return rootview;
    }


}
