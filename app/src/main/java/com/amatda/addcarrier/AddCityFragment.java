package com.amatda.addcarrier;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.amatda.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddCityFragment extends Fragment {

    private Button buttonAddCityNext;
    private Spinner spinnerAddCity;

    private ArrayAdapter spinnerAdapter;
    private ArrayList<String> listCity;

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
        spinnerAddCity = view.findViewById(R.id.spinnerAddCity);

        listCity = new ArrayList<>();
        // todo : 임시 데이터
        listCity.add("여기는");
        listCity.add("어디");
        listCity.add("나는");
        listCity.add("누구");

        // Using ArrayAdapter
        spinnerAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, listCity);
        spinnerAddCity.setAdapter(spinnerAdapter);

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
