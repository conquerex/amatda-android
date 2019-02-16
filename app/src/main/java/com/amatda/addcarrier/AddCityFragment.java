package com.amatda.addcarrier;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.amatda.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddCityFragment extends Fragment {

    private Button buttonAddCityNext;

    public AddCityFragment() {
        // Required empty public constructor
    }

    public static AddCityFragment newInstance() {
        return new AddCityFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_city, container, false);

        buttonAddCityNext = view.findViewById(R.id.buttonAddCityNext);
        buttonAddCityNext.setOnClickListener(v -> {
            AddDateFragment fragment = new AddDateFragment();
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.layoutAddCarrier, fragment);
            transaction.commit();
        });

        return view;
    }

}
