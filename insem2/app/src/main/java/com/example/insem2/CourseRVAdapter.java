package com.example.insem2;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<EmployeeModak> EmployeeModakArrayList;
    private Context context;

    // constructor
    public CourseRVAdapter(ArrayList<EmployeeModak> EmployeeModakArrayList, Context context) {
        this.EmployeeModakArrayList = EmployeeModakArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_rv_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        EmployeeModak modal = EmployeeModakArrayList.get(position);
        holder.courseNameTV.setText(modal.getName());
        holder.courseSalaryTV.setText(modal.getSalary());
        holder.courseComissionTV.setText(modal.getComission());


        // below line is to add on click listener for our recycler view item.
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // on below line we are calling an intent.
//                Intent i = new Intent(context, UpdateCourseActivity.class);
//
//                // below we are passing all our values.
//                i.putExtra("name", modal.getName());
//                i.putExtra("email", modal.getEmail());
//                i.putExtra("phone", modal.getPhone());
//
//
//                // starting our activity.
//                context.startActivity(i);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return EmployeeModakArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView courseNameTV, courseSalaryTV, courseComissionTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseSalaryTV = itemView.findViewById(R.id.idTVCourseDescription);

            courseComissionTV = itemView.findViewById(R.id.idTVCourseTracks);
        }
    }
}