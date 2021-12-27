package com.example.smdlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    ListView listView;
    String[] MobileList = {"Note 10", "Oppo", "Galaxy S20", "Nokia 3310", "Iphone 13", "A51"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        listView = findViewById(R.id.list1);

//        android.R.layout.simple_list_item_1 is sample layout
//        list context template are set in adapter object
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, MobileList);
//      setAdapter is member of listView because it is accessed with its object
        listView.setAdapter(adapter);
//
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity4.this, "Position "+position+" ID "+id, Toast.LENGTH_SHORT).show();
            }
        });
    }
}