package com.integra.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ModelDao {

    @Insert
    Long insert(Model model);

    @Query("SELECT * FROM model")
    List<Model> getList();
}
