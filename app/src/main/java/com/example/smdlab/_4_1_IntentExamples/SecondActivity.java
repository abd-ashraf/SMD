package com.example.smdlab._4_1_IntentExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.smdlab.R;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent;
        intent = getIntent();
        int Value1 = intent.getIntExtra("V1",0);
        int Value2 = intent.getIntExtra("V2",0);
        int NewValue = Value1 + Value2 + 10;
        intent.putExtra("V3",NewValue);
        setResult(RESULT_OK, intent);
        finish();

    }

    @Override
    public void finish() {
        super.finish();
    }
}