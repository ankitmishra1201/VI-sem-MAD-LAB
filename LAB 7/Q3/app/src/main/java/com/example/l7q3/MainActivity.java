package com.example.l7q3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    ImageButton i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=findViewById(R.id.imageButton);
    }
    public void showPopUp(View v){
        PopupMenu p=new PopupMenu(this,v);
        p.setOnMenuItemClickListener(this);
        p.inflate(R.menu.popup_menu);
        p.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
       switch (item.getItemId()){
           case R.id.nav_left:
                i.setImageDrawable(getResources().getDrawable(
                        R.drawable.play_img
                ));
               Toast.makeText(this, "Image 1", Toast.LENGTH_SHORT).show();

               return true;

           case R.id.nav_right:
               i.setImageDrawable(getResources().getDrawable(
                       R.drawable.baseline_pause_24
               ));
               Toast.makeText(this, "Image 2", Toast.LENGTH_SHORT).show();
               return true;
           default:
               return true;
       }
    }
}