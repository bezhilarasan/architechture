package com.integra.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.integra.myapplication.databinding.ActivityDataBindingBinding;

import java.util.ArrayList;

public class DataActivity extends AppCompatActivity {

    MyClickListener listener;
    ModelPojo modelPojo;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindingBinding activityDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        modelPojo = new ModelPojo();
        modelPojo.setName("binding data");
        context = DataActivity.this;
        activityDataBinding.setModelPojo(modelPojo);
        listener = new MyClickListener(this);
        activityDataBinding.setHandlers(listener);
        User user = new User();
        ArrayList list = new ArrayList();
        list.add("Bopati");
        user.setName("Ezhilarasan");
        user.setAge(34);
        user.setList(list);
        activityDataBinding.setUser(user);
    }

    public void toast(View view) {
        Toast.makeText(context, "THIS TOAST IS EXAMPLE", Toast.LENGTH_SHORT).show();
    }

    public void toast1(User user) {
        System.out.println("THIS IS TOAST" + user.getName());
    }


    public class MyClickListener {
        Context context;

        public MyClickListener(Context context) {
            this.context = context;
        }

        public void btn(View view) {
            modelPojo.name1.set("user");
            modelPojo.setName("button change!");

            Toast.makeText(context, "clicked!", Toast.LENGTH_SHORT).show();
        }


    }
}
