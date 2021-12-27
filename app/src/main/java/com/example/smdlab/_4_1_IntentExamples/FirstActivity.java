package com.example.smdlab._4_1_IntentExamples;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smdlab.R;

public class FirstActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        textView = findViewById(R.id.textFirstActivity);
    }

    public void GoToSecondActivity(View view) {
        Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
        intent.putExtra("V1",7);
        intent.putExtra("V2",5);
        MyResult.launch(intent);

//        Code for opening URL
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("https://www.google.com"));
//        startActivity(intent);

//        Code for opening Dialer
//        Intent intent = new Intent(Intent.ACTION_DIAL);
//        intent.setData(Uri.parse("tel:"+123456 ));
//        startActivity(intent);

    }

    ActivityResultLauncher<Intent> MyResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode()==RESULT_OK)
            {
                Intent value = result.getData();
                int newValue = value.getIntExtra("V3",5);
                Toast.makeText(FirstActivity.this, "Back in Main, Value Returned = "+ newValue, Toast.LENGTH_SHORT).show();
                Log.d("tag","msamdasdhj");
            }
        }
    });
}