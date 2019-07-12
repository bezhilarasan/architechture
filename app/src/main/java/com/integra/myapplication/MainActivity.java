package com.integra.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ModelClass modelClass;
    GridView textView;
    ParentClass parentClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);
        modelClass = ViewModelProviders.of(this).get(ModelClass.class);
        parentClass = new ParentClass();
        getLifecycle().addObserver(parentClass);
        modelClass.getData().observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object o) {
                Log.d(TAG, "onChanged: " + o);
                List<Model> models = (List<Model>) o;
                CharSequence[] sequences = new CharSequence[models.size()];
                for (int i = 0; i < models.size(); i++) {
                    sequences[i] = models.get(i).getValue() + "";
                }
                ArrayAdapter adapter = new ArrayAdapter<CharSequence>(MainActivity.this,
                        android.R.layout.simple_list_item_1, sequences);
                adapter.notifyDataSetChanged();
                textView.setAdapter(adapter);
            }
        });
    }

    public void increment(View view) {
        startActivity(new Intent(getApplicationContext(), DataActivity.class));
        modelClass.setI();
    }

    public void myview(View view) {
        startActivity(new Intent(getApplicationContext(), RecylerViewActivity.class));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(parentClass);
    }
}
