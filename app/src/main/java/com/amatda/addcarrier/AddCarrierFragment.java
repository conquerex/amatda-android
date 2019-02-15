package com.amatda.addcarrier;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amatda.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddCarrierFragment extends Fragment {


    public AddCarrierFragment() {
        // Required empty public constructor
    }

    public static AddCarrierFragment newInstance() {
        return new AddCarrierFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_carrier, container, false);
    }

}
