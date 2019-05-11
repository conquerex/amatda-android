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

import android.app.Activity;
import android.support.annotation.NonNull;

import com.amatda.UseCase;
import com.amatda.UseCaseHandler;
import com.amatda.addedittask.AddEditTaskActivity;
import com.amatda.data.MockOptionData;
import com.amatda.data.MockPreparationData;
import com.amatda.data.source.TasksDataSource;
import com.amatda.main.domain.usecase.ActivateTask;
import com.amatda.main.domain.usecase.ClearCompleteTasks;
import com.amatda.main.domain.usecase.CompleteTask;
import com.amatda.main.domain.usecase.GetTasks;
import com.amatda.main.model.CarrierDto;
import com.amatda.util.ApiInterface;
import com.amatda.util.NetworkSetting;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Listens to user actions from the UI ({@link CarrierMainFragment}), retrieves the data and updates the
 * UI as required.
 */
public class CarrierMainPresenter implements CarrierMainContract.Presenter {

    private final CarrierMainContract.View mTasksView;
    private final GetTasks mGetTasks;

    private TasksFilterType mCurrentFiltering = TasksFilterType.ALL_TASKS;

    private boolean mFirstLoad = true;
    private ApiInterface apiInterface;

    private final UseCaseHandler mUseCaseHandler;
    private Realm realm;

    public CarrierMainPresenter(@NonNull UseCaseHandler useCaseHandler,
                                @NonNull CarrierMainContract.View tasksView, @NonNull GetTasks getTasks,
                                @NonNull CompleteTask completeTask, @NonNull ActivateTask activateTask,
                                @NonNull ClearCompleteTasks clearCompleteTasks) {
        mUseCaseHandler = checkNotNull(useCaseHandler, "usecaseHandler cannot be null");
        mTasksView = checkNotNull(tasksView, "tasksView cannot be null!");
        mGetTasks = checkNotNull(getTasks, "getTask cannot be null!");
        mTasksView.setPresenter(this);
    }

    public void getListAll(int cId) {
        apiInterface = NetworkSetting.getClient().create(ApiInterface.class);
        Call<Void> call = apiInterface.getListAll(cId);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    @Override
    public void getInfoCarrier(int cId) {
        apiInterface = NetworkSetting.getClient().create(ApiInterface.class);
        Call<CarrierDto> call = apiInterface.getInfoCarrier(cId);
        call.enqueue(new Callback<CarrierDto>() {
            @Override
            public void onResponse(Call<CarrierDto> call, Response<CarrierDto> response) {
                //
            }

            @Override
            public void onFailure(Call<CarrierDto> call, Throwable t) {

            }
        });
    }

    @Override
    public void getWeather(int city_id, int month) {

    }

    @Override
    public void start() {
        realm = Realm.getDefaultInstance();
        // Todo : where 조건이 필요
        RealmResults<MockPreparationData> results = realm.where(MockPreparationData.class).findAll();
        if (results.isEmpty() || results.size() < 5) {
            realm.beginTransaction();
            for (int i = 4; i < 11; i++) {
                MockPreparationData data = new MockPreparationData();
                data.setId(i);
                data.setCreateDate(System.currentTimeMillis());
                data.setName("준비물 " + i);
                MockOptionData optionData = new MockOptionData();
                optionData.setOption("Option" + i);
                data.setRecommend(i / 2 == 0);
                realm.copyToRealm(data);
            }
            realm.commitTransaction();
        }

        loadTasks(false);
    }

    @Override
    public void result(int requestCode, int resultCode) {
        // If a task was successfully added, show snackbar
        if (AddEditTaskActivity.REQUEST_ADD_TASK == requestCode
                && Activity.RESULT_OK == resultCode) {
            //
        }
    }

    @Override
    public void loadTasks(boolean forceUpdate) {
        // Simplification for sample: a network reload will be forced on first load.
        loadTasks(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }

    /**
     * @param forceUpdate   Pass in true to refresh the data in the {@link TasksDataSource}
     * @param showLoadingUI Pass in true to display a loading icon in the UI
     */
    private void loadTasks(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            //
        }

        GetTasks.RequestValues requestValue = new GetTasks.RequestValues(forceUpdate,
                mCurrentFiltering);

        mUseCaseHandler.execute(mGetTasks, requestValue,
                new UseCase.UseCaseCallback<GetTasks.ResponseValue>() {
                    @Override
                    public void onSuccess(GetTasks.ResponseValue response) {
                        //
                    }

                    @Override
                    public void onError() {
                        //
                    }
                });
    }


    @Override
    public void addNewTask() {
        mTasksView.showAddTask();
    }
}
