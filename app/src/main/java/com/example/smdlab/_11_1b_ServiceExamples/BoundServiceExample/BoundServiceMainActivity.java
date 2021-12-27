package com.example.smdlab._11_1b_ServiceExamples.BoundServiceExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.example.smdlab.R;

public class BoundServiceMainActivity extends AppCompatActivity {

    MyBoundService myBoundMediaPlayerService;
    public boolean myBoundService = false;
    public ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) service;
            myBoundMediaPlayerService = myBinder.getServiceMethod();
            myBoundService = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyBoundService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (myBoundService == true) {
            unbindService(serviceConnection);
        }
    }

    public void Play(View view) {
//        check connection
        if (myBoundService == true) {
//            check if playing
            if (myBoundMediaPlayerService.isPlay()) {
                myBoundMediaPlayerService.Pause();
            }
            else {
                myBoundMediaPlayerService.Play();
            }
        }
    }
}