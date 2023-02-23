package com.example.q4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText url;
    WebView webview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url=(EditText) findViewById(R.id.url);
    }

    public void onClick(View view){
        webview=findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(url.getText().toString());
        WebSettings webSettings=webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}