package com.fpt.edu.nguyenminhtuan.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Employee.class},version=1)

public abstract class Appdatabase extends RoomDatabase {
    private static Appdatabase appdatabase;
    public abstract EmployeeDao employeeDao();
    public static Appdatabase getAppdatabase(Context context){
        if (appdatabase==null){
            appdatabase = Room.databaseBuilder(context,Appdatabase.class,"Employee.db").allowMainThreadQueries().build();
        }
        return appdatabase;
    }
}
