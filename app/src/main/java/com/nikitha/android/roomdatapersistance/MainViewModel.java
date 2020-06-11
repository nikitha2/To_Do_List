package com.nikitha.android.roomdatapersistance;

import android.app.Application;
import android.util.Log;
import com.nikitha.android.roomdatapersistance.database.AppDatabase;
import com.nikitha.android.roomdatapersistance.database.TaskEntry;
import com.nikitha.android.roomdatapersistance.database.TasksRepository;

import java.util.List;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MainViewModel extends AndroidViewModel {

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<TaskEntry>> tasks;
    private final TasksRepository tasksRepository;
    public MainViewModel(Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the DataBase");
        //tasks = database.taskDao().loadAllTasks();
        tasksRepository = new TasksRepository(database);
        tasks = tasksRepository.getloadAllTasks();
    }

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }

    public void deleteTask(TaskEntry taskEntry) {
        tasksRepository.deleteTasks(taskEntry);
    }
}