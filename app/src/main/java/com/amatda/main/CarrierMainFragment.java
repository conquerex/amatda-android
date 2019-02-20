/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.amatda.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.amatda.R;
import com.amatda.addcarrier.AddCarrierActivity;
import com.amatda.addedittask.AddEditTaskActivity;
import com.amatda.data.MockPreparationData;
import com.amatda.main.domain.model.Task;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Display a grid of {@link Task}s. User can choose to view all, active or completed tasks.
 */
public class CarrierMainFragment extends Fragment
        implements CarrierMainContract.View, View.OnClickListener {

    private CarrierMainContract.Presenter mPresenter;
    private PreparationBeforeListAdapter mBeforeListAdapter;
    private PreparationBeforeListAdapter mAfterListAdapter;
    private ArrayList<MockPreparationData> mBeforeDatas;
    private ArrayList<MockPreparationData> mAfterDatas;
    private BottomSheetBehavior bottomSheetBehavior;

    private LinearLayout layoutCarrierMainBottomSheet;
    private FloatingActionButton fabCarrierAddPreparation;
    private RecyclerView recyclerCarrierMainBeforeList;
    private ImageView imageCarrierMainMenu;
    private ImageView imageCarrierMainSetting;
    private View viewCarrierMainCancelScreen;
    private ImageView imageCarrierMainSample;

    private int cId;

    public CarrierMainFragment() {
        // Requires empty public constructor
    }

    public static CarrierMainFragment newInstance(int cId) {
        Bundle args = new Bundle();
        args.putInt(CarrierMainActivity.KEY_CARRIER_ID, cId);
        CarrierMainFragment fragment = new CarrierMainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeforeDatas = new ArrayList<>();
        mAfterDatas = new ArrayList<>();
        mPresenter.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        RealmResults<MockPreparationData> realmResults = Realm.getDefaultInstance().where(MockPreparationData.class).findAll();
        for (MockPreparationData data : realmResults) {
            mBeforeDatas.add(data);
        }
    }

    @Override
    public void setPresenter(@NonNull CarrierMainContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.result(requestCode, resultCode);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carrier_main, container, false);

        if (getArguments() != null) {
            cId = getArguments().getInt(CarrierMainActivity.KEY_CARRIER_ID);
        } else {
            cId = 0;
        }

        mPresenter.getInfoCarrier(cId);

        layoutCarrierMainBottomSheet = view.findViewById(R.id.layoutCarrierMainBottomSheet);
        imageCarrierMainMenu = view.findViewById(R.id.imageCarrierMainMenu);
        imageCarrierMainSetting = view.findViewById(R.id.imageCarrierMainSetting);
        recyclerCarrierMainBeforeList = view.findViewById(R.id.recyclerCarrierMainBeforeList);
        viewCarrierMainCancelScreen = view.findViewById(R.id.viewCarrierMainCancelScreen);
        imageCarrierMainSample = view.findViewById(R.id.imageCarrierMainSample);

        imageCarrierMainMenu.setOnClickListener(this);
        imageCarrierMainSetting.setOnClickListener(this);
        viewCarrierMainCancelScreen.setOnClickListener(this);
        imageCarrierMainSample.setOnClickListener(this);

        // Set up floating action button
        fabCarrierAddPreparation = getActivity().findViewById(R.id.fabCarrierAddPreparation);

        fabCarrierAddPreparation.setImageResource(R.drawable.ic_add);
        fabCarrierAddPreparation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addNewTask();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        // Uncheck list
        mBeforeListAdapter = new PreparationBeforeListAdapter();
        recyclerCarrierMainBeforeList.setAdapter(mBeforeListAdapter);
        recyclerCarrierMainBeforeList.setLayoutManager(layoutManager);
        mBeforeListAdapter.notifyDataSetChanged();

        // Checked list
        mAfterListAdapter = new PreparationBeforeListAdapter();
        recyclerCarrierMainBeforeList.setAdapter(mAfterListAdapter);
        recyclerCarrierMainBeforeList.setLayoutManager(layoutManager);
        mAfterListAdapter.notifyDataSetChanged();

        bottomSheetBehavior = BottomSheetBehavior.from(layoutCarrierMainBottomSheet);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_EXPANDED:
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // Slide ...
                // 1이면 완전 펼쳐진 상태
                // 0이면 peekHeight인 상태
                // -1이면 숨김 상태
            }
        });
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        return view;
    }

    @Override
    public void showTasks(List<Task> tasks) {
        //
    }

    @Override
    public void showAddTask() {
        Intent intent = new Intent(getContext(), AddEditTaskActivity.class);
        startActivityForResult(intent, AddEditTaskActivity.REQUEST_ADD_TASK);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageCarrierMainMenu:
                viewCarrierMainCancelScreen.setVisibility(View.VISIBLE);
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                // todo : Remove soon
                mPresenter.getListAll(cId);
                break;
            case R.id.imageCarrierMainSetting:
                viewCarrierMainCancelScreen.setVisibility(View.VISIBLE);
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.viewCarrierMainCancelScreen:
                viewCarrierMainCancelScreen.setVisibility(View.GONE);
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                break;
            case R.id.imageCarrierMainSample:
                AddCarrierActivity.startAddCarrierActivity(getContext());
                break;
            default:
                break;
        }
    }

    private class PreparationBeforeListAdapter extends RecyclerView.Adapter<PreparationViewHolder> {

        @Override
        public PreparationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_preparation, parent, false);
            PreparationViewHolder viewHolder = new PreparationViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(PreparationViewHolder holder, int position) {
            holder.setData(mBeforeDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mBeforeDatas.size();
        }
    }

    private class PreparationAfterListAdapter extends RecyclerView.Adapter<PreparationViewHolder> {

        @Override
        public PreparationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_preparation, parent, false);
            PreparationViewHolder viewHolder = new PreparationViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(PreparationViewHolder holder, int position) {
            holder.setData(mAfterDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mAfterDatas.size();
        }
    }
}
