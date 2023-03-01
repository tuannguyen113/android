package com.fpt.edu.nguyenminhtuan.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Insert
    long insertEmp(Employee emp);
    @Update
    int updateEmp(Employee emp);
    @Delete
    int deleteEmp(Employee emp);
    @Query("select * from employee where id=:id")
    Employee findEmp(int id);
    @Query("Select * from employee")
    List<Employee> getAllEmp();
}

