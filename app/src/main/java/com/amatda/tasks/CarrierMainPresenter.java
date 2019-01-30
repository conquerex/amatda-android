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

package com.amatda.tasks;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.amatda.UseCase;
import com.amatda.UseCaseHandler;
import com.amatda.addedittask.AddEditTaskActivity;
import com.amatda.data.source.TasksDataSource;
import com.amatda.tasks.domain.usecase.ActivateTask;
import com.amatda.tasks.domain.usecase.ClearCompleteTasks;
import com.amatda.tasks.domain.usecase.CompleteTask;
import com.amatda.tasks.domain.usecase.GetTasks;
import com.amatda.util.ApiInterface;
import com.amatda.util.NetworkSetting;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Listens to user actions from the UI ({@link CarrierMainFragment}), retrieves the data and updates the
 * UI as required.
 */
public class CarrierMainPresenter implements TasksContract.Presenter {

    private final TasksContract.View mTasksView;
    private final GetTasks mGetTasks;

    private TasksFilterType mCurrentFiltering = TasksFilterType.ALL_TASKS;

    private boolean mFirstLoad = true;
    private ApiInterface apiInterface;

    private final UseCaseHandler mUseCaseHandler;

    public CarrierMainPresenter(@NonNull UseCaseHandler useCaseHandler,
                                @NonNull TasksContract.View tasksView, @NonNull GetTasks getTasks,
                                @NonNull CompleteTask completeTask, @NonNull ActivateTask activateTask,
                                @NonNull ClearCompleteTasks clearCompleteTasks) {
        mUseCaseHandler = checkNotNull(useCaseHandler, "usecaseHandler cannot be null");
        mTasksView = checkNotNull(tasksView, "tasksView cannot be null!");
        mGetTasks = checkNotNull(getTasks, "getTask cannot be null!");

        mTasksView.setPresenter(this);
    }

    public void getJKStest() {
        apiInterface = NetworkSetting.getClient().create(ApiInterface.class);

        Call<Void> call = apiInterface.getTestApi();
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
    public void start() {
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
