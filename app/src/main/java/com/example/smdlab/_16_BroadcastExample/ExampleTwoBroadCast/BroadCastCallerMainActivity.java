package com.example.smdlab._16_BroadcastExample.ExampleTwoBroadCast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.smdlab.R;

public class BroadCastCallerMainActivity extends AppCompatActivity {
//    make obj of receiver BC
    MyReceiverCaller obj = new MyReceiverCaller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_caller_main);

//        app crashing because of this intent
        Intent intent = new Intent(this, MyReceiverCaller.class);
        sendBroadcast(intent);
    }
}