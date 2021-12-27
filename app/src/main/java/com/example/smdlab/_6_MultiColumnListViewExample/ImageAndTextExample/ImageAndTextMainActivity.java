package com.example.smdlab._6_MultiColumnListViewExample.ImageAndTextExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.smdlab.R;

public class ImageAndTextMainActivity extends AppCompatActivity {
    ListView listView;
    String name[] = {"Ali", "Ahmad", "Aqib", "Bilal", "Munir"};
    String Text[] = {"Ali bahir ao", "Assignment Send krdo", "Mere paisay wapis kro", "bhook lagi hy", "Break ka time hogya"};
    int Image[] = {R.drawable.brooklyn, R.drawable.canyon, R.drawable.chicago, R.drawable.miro, R.drawable.city};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_and_text_main);

        listView = findViewById(R.id.lstImageAndText);

        MyAdapterList obj = new MyAdapterList(this, name, Text, Image);
        listView.setAdapter(obj);

    }
}