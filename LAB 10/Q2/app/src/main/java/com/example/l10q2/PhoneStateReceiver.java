package com.example.l10q2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.d("Phone State", "Phone is ringing with incoming number: " + incomingNumber);
            } else if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
                Log.d("Phone State", "Phone is idle");
            } else if (state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
                Log.d("Phone State", "Phone is offhook");
            }
        }
    }
}
