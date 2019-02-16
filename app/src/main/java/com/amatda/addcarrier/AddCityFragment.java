package com.amatda.addcarrier;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.amatda.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * city_id - 나라 이름
 *   1 - 일본 오사카
 *   2 - 중국 베이징
 *   3 - 미국 하와이
 *   4 - 미국 뉴욕
 *   5 - 독일 베를린
 *   6 - 프랑스 파리
 *   7 - 베트남 다낭
 */
public class AddCityFragment extends Fragment {

    private Button buttonAddCityNext;
    private Spinner spinnerAddCity;

    private ArrayAdapter spinnerAdapter;
    private ArrayList<String> listCity;
    private HashMap<Integer, String> mapCity;

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

        mapCity = new HashMap<>();
        mapCity.put(1, "일본 오사카");
        mapCity.put(2, "중국 베이징");
        mapCity.put(3, "미국 하와이");
        mapCity.put(4, "미국 뉴욕");
        mapCity.put(5, "독일 베를린");
        mapCity.put(6, "프랑스 파리");
        mapCity.put(7, "베트남 다낭");

        listCity = new ArrayList<>();
        for (int i = 1; i < mapCity.size() + 1; i++) {
//            Log.d("AddCityFragment", " * * * city : " + mapCity.get(i));
            listCity.add(mapCity.get(i));
        }

        // Using ArrayAdapter
        spinnerAdapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, listCity);
        spinnerAddCity.setAdapter(spinnerAdapter);

        buttonAddCityNext.setOnClickListener(v -> {
            AddDateFragment fragment = AddDateFragment.newInstance(spinnerAddCity.getSelectedItemPosition() + 1);
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.layoutAddCarrier, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });

        return view;
    }

}
