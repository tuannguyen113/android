package com.fpt.edu.nguyenminhtuan.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fpt.edu.nguyenminhtuan.R;
import com.fpt.edu.nguyenminhtuan.database.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter {
    Activity activity;
    List<Employee> lisEmp;
    public EmployeeAdapter(Activity activity,List<Employee> lisEmp){
        this.activity=activity;
        this.lisEmp=lisEmp;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_employee,parent,false);
        EmployeeHolder holder = new EmployeeHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmployeeHolder vh = (EmployeeHolder) holder;
        Employee model = lisEmp.get(position);
        vh.tvName.setText(model.name+"");
        vh.tvSalary.setText(model.salary+"");
        vh.tvLocation.setText(model.designation+"");
    }

    @Override
    public int getItemCount() {
        return lisEmp.size();
    }
    public class EmployeeHolder extends RecyclerView.ViewHolder{
        TextView tvName,tvSalary,tvLocation;
        public EmployeeHolder(@NonNull View itemView){
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvSalary = itemView.findViewById(R.id.tvSalary);
            tvLocation = itemView.findViewById(R.id.tvLocation);

        }
    }
}
