package com.example.smdlab._5_PermissionExamples2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.smdlab.R;

public class PermissionOpenSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_open_second);
    }

    public void OpenBoomActivity(View view) {
        startActivity(new Intent("com.example.boomactivity"));
    }
}