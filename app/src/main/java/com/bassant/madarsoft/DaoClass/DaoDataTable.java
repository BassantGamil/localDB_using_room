package com.bassant.madarsoft.DaoClass;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.bassant.madarsoft.Model.UserModel;

import java.util.List;

@Dao
public interface DaoDataTable  {
    @Insert
    void insertData(UserModel userModel);

    @Query("Select * from user ")
    List<UserModel> getAllData();

}
