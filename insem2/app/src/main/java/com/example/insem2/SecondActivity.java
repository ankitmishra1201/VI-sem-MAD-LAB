package com.example.insem2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    EditText name,salary,commision;
    Button submit;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        name=findViewById(R.id.nameET);
        salary=findViewById(R.id.salaryET);
        commision=findViewById(R.id.comissionET);
        submit=findViewById(R.id.submitbtn);
        dbHandler=new DBHandler(SecondActivity.this);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String courseName = name.getText().toString();
                String courseSalary = salary.getText().toString();
                String courseCommision = commision.getText().toString();


                // validating if the text fields are empty or not.
                if (courseName.isEmpty() || courseSalary.isEmpty() || courseCommision.isEmpty()) {
                    Toast.makeText(SecondActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }


                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewCourse(courseName, courseSalary, courseCommision);

                // after adding the data we are displaying a toast message.
                Toast.makeText(SecondActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                //RESETING TEXT FIELD
                Intent i=new Intent(SecondActivity.this,MainActivity.class);
                startActivity(i);
            }
        });


    }



}