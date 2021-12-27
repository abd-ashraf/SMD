package com.example.smdlab._11_1b_ServiceExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.smdlab.R;

public class ServiceExampleOneMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example_one_main);
    }

    public void StartMyService(View view) {
        Intent intent = new Intent(this, MyServiceExampleOne.class);
//        not startActivity because this is service
        startService(intent);
    }

    public void StopMyService(View view) {
        Intent intent = new Intent(this, MyServiceExampleOne.class);
        stopService(intent);
    }
}