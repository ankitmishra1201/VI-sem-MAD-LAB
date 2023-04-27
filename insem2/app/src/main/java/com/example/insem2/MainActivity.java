package com.example.insem2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button popup;
    private ArrayList<EmployeeModak> EmployeeModakArrayList;
    private CourseRVAdapter courseRVAdapter;
    private RecyclerView coursesRV;
    private DBHandler dbHandler;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmployeeModakArrayList = new ArrayList<>();
        dbHandler = new DBHandler(MainActivity.this);

        // getting our course array
        // list from db handler class.

        EmployeeModakArrayList = dbHandler.readCourses();



        // on below line passing our array list to our adapter class.
        courseRVAdapter = new CourseRVAdapter(EmployeeModakArrayList, MainActivity.this);
        coursesRV = findViewById(R.id.recyclerView);
        coursesRV.setAlpha(0);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        coursesRV.setAdapter(courseRVAdapter);


        popup=findViewById(R.id.popup);

        PopupMenu popupMenu = new PopupMenu(
                this,
                popup
        );

        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id= menuItem.getItemId();
                if(id==R.id.menu_update){
                    Intent i=new Intent(MainActivity.this,ThirdActivity.class);
                    startActivity(i);

                    Toast.makeText(MainActivity.this, "Update", Toast.LENGTH_SHORT).show();
                }
                else if(id==R.id.menu_entry){
                    Intent i=new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(i);

                }

                return false;

            }
        });

        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenu.show();
            }
        });






    }
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

                Intent i=new Intent(MainActivity.this,ViewCourses.class);
                startActivity(i);
                return true;
            case R.id.item2:
                coursesRV.setAlpha(1);
                Toast.makeText(this, "Same Page selected", Toast.LENGTH_SHORT).show();
                return true;

            default: return super.onOptionsItemSelected(item);
        }

    }
///**********************END MENU OPTION IN THE APP BAR******************************///

}