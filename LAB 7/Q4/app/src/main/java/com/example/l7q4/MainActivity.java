package com.example.l7q4;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private TextView contentView;
    private ArrayList<String> keywordsList = new ArrayList<>();
    private boolean sortAscending = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentView = findViewById(R.id.content_view);
        contentView.setText(getString(R.string.demonitization_content));

        keywordsList.add("demonetization");
        keywordsList.add("currency");
        keywordsList.add("bank");

        // Sort the keywords list alphabetically
        Collections.sort(keywordsList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.keywords_filter) {

        } else if (itemId == R.id.sort_filter) {

            sortAscending = !sortAscending;

            if (sortAscending) {
                Collections.sort(keywordsList);
            } else {
                Collections.reverse(keywordsList);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
