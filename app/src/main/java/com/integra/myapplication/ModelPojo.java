package com.integra.myapplication;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

public class ModelPojo extends BaseObservable {

    public static ObservableField<String> name1 = new ObservableField<>();
    String name;

    public static ObservableField<String> getStringObservableField() {
        return name1;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
