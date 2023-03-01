package com.fpt.edu.nguyenminhtuan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fpt.edu.nguyenminhtuan.adapter.EmployeeAdapter;
import com.fpt.edu.nguyenminhtuan.database.Appdatabase;
import com.fpt.edu.nguyenminhtuan.database.Employee;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edName,edSalary,edDes;
    RecyclerView rvEmp;
    Appdatabase db;
    Button btAdd,btUpdate,btDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=Appdatabase.getAppdatabase(this);
        edName=findViewById(R.id.edName);
        edSalary=findViewById(R.id.edSalary);
        edDes=findViewById(R.id.edDes);
        btAdd=findViewById(R.id.btAdd);
        btUpdate=findViewById(R.id.btUpdate);
        btDelete=findViewById(R.id.btDelete);
        btAdd.setOnClickListener(this);

        List<Employee> list = db.employeeDao().getAllEmp();
        EmployeeAdapter adapter = new EmployeeAdapter(this,list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rvEmp=findViewById(R.id.rvEmp);
        rvEmp.setLayoutManager(layoutManager);
        rvEmp.setAdapter(adapter);

    }
    private void AddEmp(){
        if (!validate()){
            return;
        }
        Employee emp = new Employee();
        emp.name = edName.getText().toString();
        emp.designation=edDes.getText().toString();
        emp.salary= Double.parseDouble(edSalary.getText().toString());
        long id = db.employeeDao().insertEmp(emp);
        if (id>0){
            Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
        }
        goToEmp();
    }
    private void goToEmp(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    private boolean validate(){
        String mes = null;
        if (edName.getText().toString().trim().isEmpty()){
            mes="Chưa nhập name";
        } else if (edDes.getText().toString().trim().isEmpty()) {
            mes="Chưa nhập Designation";

        } else if (edSalary.getText().toString().trim().isEmpty()) {
            mes="Chưa nhập Salary";

        }
        if(mes!=null){
            Toast.makeText(this,mes,Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btAdd:
                AddEmp();
                break;
            case R.id.btUpdate:
                AddEmp();
                break;
            default:
                break;
        }
    }
}