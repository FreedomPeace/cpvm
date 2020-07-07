package com.example.mvvm.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LogInfoDao {
    @Query("Select * from LogInfo")
    List<LogInfo> getLogInfos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(LogInfo logInfo);

}
