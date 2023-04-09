package com.example.l10q2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.TelephonyManager;

import com.example.l10q2.PhoneStateReceiver;

public class MainActivity extends AppCompatActivity {

    PhoneStateReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a new instance of the broadcast receiver
        receiver = new PhoneStateReceiver();

        // Register the receiver to listen for phone state changes
        IntentFilter filter = new IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Unregister the receiver when the activity is destroyed
        unregisterReceiver(receiver);
    }
}
