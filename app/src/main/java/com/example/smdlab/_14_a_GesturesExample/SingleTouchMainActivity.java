package com.example.smdlab._14_a_GesturesExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SingleTouchMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SingleTouchView(this, null));
    }
}