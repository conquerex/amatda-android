/*
 * Copyright (C) 2015 The Android Open Source Project
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

package com.amatda;

import android.content.Context;
import android.support.annotation.NonNull;

import com.amatda.addedittask.domain.usecase.DeleteTask;
import com.amatda.addedittask.domain.usecase.GetTask;
import com.amatda.addedittask.domain.usecase.SaveTask;
import com.amatda.data.FakeTasksRemoteDataSource;
import com.amatda.data.source.TasksDataSource;
import com.amatda.data.source.TasksRepository;
import com.amatda.data.source.local.TasksLocalDataSource;
import com.amatda.data.source.local.ToDoDatabase;
import com.amatda.main.domain.filter.FilterFactory;
import com.amatda.main.domain.usecase.ActivateTask;
import com.amatda.main.domain.usecase.ClearCompleteTasks;
import com.amatda.main.domain.usecase.CompleteTask;
import com.amatda.main.domain.usecase.GetTasks;
import com.amatda.util.AppExecutors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Enables injection of mock implementations for
 * {@link TasksDataSource} at compile time. This is useful for testing, since it allows us to use
 * a fake instance of the class to isolate the dependencies and run a test hermetically.
 */
public class Injection {

    public static TasksRepository provideTasksRepository(@NonNull Context context) {
        checkNotNull(context);
        ToDoDatabase database = ToDoDatabase.getInstance(context);
        return TasksRepository.getInstance(FakeTasksRemoteDataSource.getInstance(),
                TasksLocalDataSource.getInstance(new AppExecutors(),
                        database.taskDao()));
    }

    public static GetTasks provideGetTasks(@NonNull Context context) {
        return new GetTasks(provideTasksRepository(context), new FilterFactory());
    }

    public static UseCaseHandler provideUseCaseHandler() {
        return UseCaseHandler.getInstance();
    }

    public static GetTask provideGetTask(@NonNull Context context) {
        return new GetTask(Injection.provideTasksRepository(context));
    }

    public static SaveTask provideSaveTask(@NonNull Context context) {
        return new SaveTask(Injection.provideTasksRepository(context));
    }

    public static CompleteTask provideCompleteTasks(@NonNull Context context) {
        return new CompleteTask(Injection.provideTasksRepository(context));
    }

    public static ActivateTask provideActivateTask(@NonNull Context context) {
        return new ActivateTask(Injection.provideTasksRepository(context));
    }

    public static ClearCompleteTasks provideClearCompleteTasks(@NonNull Context context) {
        return new ClearCompleteTasks(Injection.provideTasksRepository(context));
    }

    public static DeleteTask provideDeleteTask(@NonNull Context context) {
        return new DeleteTask(Injection.provideTasksRepository(context));
    }

//    public static GetStatistics provideGetStatistics(@NonNull Context context) {
//        return new GetStatistics(Injection.provideTasksRepository(context));
//    }
}
