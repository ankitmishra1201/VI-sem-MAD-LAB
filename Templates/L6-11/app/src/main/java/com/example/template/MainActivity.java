package com.example.template;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private EditText courseNameEdt, courseTracksEdt, courseDurationEdt, courseDescriptionEdt;
    private Button addCourseBtn, readCourseBtn,shareBtn,showMenuBtn;
    private DBHandler dbHandler;

///**********************MENU OPTION IN THE APP BAR******************************///
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;

            default: return super.onOptionsItemSelected(item);
        }

    }
///**********************END MENU OPTION IN THE APP BAR******************************///

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // initializing all our variables.
        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseTracksEdt = findViewById(R.id.idEdtCourseTracks);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        addCourseBtn = findViewById(R.id.idBtnAddCourse);
        readCourseBtn = findViewById(R.id.idBtnReadCourse);
        shareBtn=findViewById(R.id.share);
        showMenuBtn=findViewById(R.id.showMenuBtn);
        dbHandler = new DBHandler(MainActivity.this);

//////////**********************POPUP MENU********************************************////////////
        PopupMenu popupMenu = new PopupMenu(
                this,
                showMenuBtn
        );

        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id= menuItem.getItemId();
                if(id==R.id.menu_copy){
                    Toast.makeText(MainActivity.this, "Copy Selected", Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.menu_share){
                    Toast.makeText(MainActivity.this, "Share Selected", Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.menu_save){
                    Toast.makeText(MainActivity.this, "Save Selected", Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.menu_delete){
                    Toast.makeText(MainActivity.this, "Deleted Selected", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        showMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenu.show();
            }
        });

//////////**********************POPUP MENU END********************************************///

///*****************************SQLLITE PORTION*******************************
///*****************************END OF SQLLITE PART*******************************************************************///

///*********************************************SHARE INTENT*********************************************************///
        ///ADD THE PERMISSION IN MANIFEST.XML, READEXTERNAL and WRITEEXTERNAL one.
        /// THE INTENT BELOW IS MADE TO SHARE TEXT TO OTHER APPS, TO SHARE OTHER RESOURCE REFER GOOGLE
        ///FOR OTHER APP RESOURCES LIKE GOOGLE MAPS OR SOME OTHER APP, REFER GOOGLE OR CHATGPT

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Enter your resource here");

                Intent chooser = Intent.createChooser(intent, "Share Intent");

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }
        });
///*********************************************END OF SHARE INTENT*********************************************************///



    }
}