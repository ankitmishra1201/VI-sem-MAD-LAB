package com.example.template;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class UpdateCourseActivity extends AppCompatActivity {


    // variables for our edit text, button, strings and dbhandler class.
    private EditText name, email, phone;
    private Button updateCourseBtn, deleteCourseBtn;
    private DBHandler dbHandler;
    String Name, Email, Phone;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_course);


        // initializing all our variables.
        name = findViewById(R.id.idEdtName);
        email = findViewById(R.id.idEdtEmail);
        phone = findViewById(R.id.idEdtPhone);

        updateCourseBtn = findViewById(R.id.idBtnUpdateCourse);
        deleteCourseBtn = findViewById(R.id.idBtnDelete);


        // on below line we are initializing our dbhandler class.

        dbHandler = new DBHandler(UpdateCourseActivity.this);

        // on below lines we are getting data which
        // we passed in our adapter class.
        Name = getIntent().getStringExtra("name");
        Email = getIntent().getStringExtra("email");
        Phone = getIntent().getStringExtra("phone");


        // setting data to edit text
        // of our update activity.
        name.setText(Name);

        email.setText(Email);
        phone.setText(Phone);


        // adding on click listener to our update course button.
        updateCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.updateCourse(Name, name.getText().toString(), email.getText().toString(), phone.getText().toString());
                // displaying a toast message that our course has been updated.
                Toast.makeText(UpdateCourseActivity.this, "Course Updated..", Toast.LENGTH_SHORT).show();
                // launching our main activity.

                Intent i = new Intent(UpdateCourseActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        // adding on click listener for delete button to delete our course.
        deleteCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our course.
                dbHandler.deleteCourse(Name);
                Toast.makeText(UpdateCourseActivity.this, "Deleted the course", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateCourseActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}