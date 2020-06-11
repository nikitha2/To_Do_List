package com.nikitha.android.roomdatapersistance;

import com.nikitha.android.roomdatapersistance.database.AppDatabase;
import com.nikitha.android.roomdatapersistance.database.TaskEntry;
import com.nikitha.android.roomdatapersistance.database.TasksRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class AddTaskViewModel extends ViewModel {

    // COMPLETED (6) Add a task member variable for the TaskEntry object wrapped in a LiveData
    private LiveData<TaskEntry> task;
    private final TasksRepository tasksRepository;

    // COMPLETED (8) Create a constructor where you call loadTaskById of the taskDao to initialize the tasks variable
    // Note: The constructor should receive the database and the taskId
    public AddTaskViewModel(AppDatabase database, int taskId) {
       // task = database.taskDao().loadTaskById(taskId);
        tasksRepository = new TasksRepository(database);
        task = tasksRepository.getloadTaskById(taskId);
    }

    // COMPLETED (7) Create a getter for the task variable
    public LiveData<TaskEntry> getTask() {
        return task;
    }

    public void updateTask(TaskEntry task) {

        tasksRepository.updateTaskById(task);
    }
}
