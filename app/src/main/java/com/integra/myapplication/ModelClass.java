package com.integra.myapplication;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ModelClass extends AndroidViewModel {

    private static final String TAG = "ModelClass";
    MutableLiveData data;
    DB db;
    int i = 0;

    ExecutorService service;

    public ModelClass(@NonNull Application application) {
        super(application);
        db = DB.getInstance(application.getApplicationContext());
        Log.d(TAG, "ModelClass: ");
        data = new MutableLiveData();
        service = Executors.newSingleThreadExecutor();
    }

    public MutableLiveData getData() {
        return data;
    }

    public void setI() {
        read();
        i++;
        insert();
    }

    private void read() {
        service.execute(new Runnable() {
            @Override
            public void run() {
                List<Model> models = db.modelDao().getList();
                if (models == null) {
                    Model model = new Model();
                    model.setValue(0);
                    models.add(model);
                }
                data.postValue(models);
            }
        });
    }

    private void insert() {
        Log.d(TAG, "insert: " + i);
        service.execute(new Runnable() {
            @Override
            public void run() {
                Model model = new Model();
                model.setValue(i);
                db.modelDao().insert(model);
            }
        });
    }

    public String getI() {
        return "" + i;
    }

}
