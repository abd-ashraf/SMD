package com.example.smdlab._16_BroadcastExample.ExampleTwoBroadCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyReceiverCaller extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
//        if state jo ai wo equal to ringing state hy then, make a toast to show mssg
        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            Toast.makeText(context, "Phone is Ringing", Toast.LENGTH_SHORT).show();
        }
//        if connection is done
        if (state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
            Toast.makeText(context, "Call Received", Toast.LENGTH_SHORT).show();
        }
//        idle state
        if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)) {
            Toast.makeText(context, "Phone is Idle.", Toast.LENGTH_SHORT).show();
        }

    }
}