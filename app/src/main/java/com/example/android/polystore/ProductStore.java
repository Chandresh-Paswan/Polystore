package com.example.android.polystore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class ProductStore extends Fragment {

    private String[] state = {"", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh",
            "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka",
            "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa",
            "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura", "Telangana", "Uttarakhand",
            "Uttaranchal", "Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh",
            "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Lakshadweep", "Pondicherry"};

    private String[] city={"","Jaunpur","Kolkata","Bokaro","East Champaran","Lucknow"};
    Spinner mState,mCity;

    EditText mCountry,mArea,mLandmark,mStoreName;

    public ProductStore() {
        // Required empty public constructor
    }

    public static ProductStore newInstance(String param1, String param2) {
        ProductStore fragment = new ProductStore();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_product_store, container, false);

        mCountry=rootview.findViewById(R.id.country);
        mArea=rootview.findViewById(R.id.area);
        mLandmark=rootview.findViewById(R.id.landmark);
        mStoreName=rootview.findViewById(R.id.store_name);

        mState=(Spinner) rootview.findViewById(R.id.state);

        ArrayAdapter stateAdapter = new ArrayAdapter(getActivity(),R.layout.layout_spinner_item,state);
        stateAdapter.setDropDownViewResource(R.layout.layout_spinner_dropdown);
        mState.setAdapter(stateAdapter);

        mCity=(Spinner) rootview.findViewById(R.id.city);
        ArrayAdapter cityAdapter = new ArrayAdapter(getActivity(),R.layout.layout_spinner_item,city);
        cityAdapter.setDropDownViewResource(R.layout.layout_spinner_dropdown);
        mCity.setAdapter(cityAdapter);

        return rootview;
    }
}
