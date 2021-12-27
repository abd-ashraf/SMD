package com.example.smdlab._6_MultiColumnListViewExample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.smdlab.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiColumnListViewMainActivity extends AppCompatActivity {

//    ArrayList will have HM type values and HM will have String type values for both key/value pairs
    public ArrayList<HashMap<String, String>> list;
    Activity activity;
    ListView listView;
//    Final keyword == Constant
    public static final String FIRST_COLUMN = "First";
    public static final String SECOND_COLUMN = "Second";
    public static final String THIRD_COLUMN = "Third";
    public static final String FOURTH_COLUMN = "Fourth";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_column_list_view_main);

        listView = findViewById(R.id.lstMultiColumn);

        LoadData();
        MyListAdapter myListAdapter = new MyListAdapter(list, this);
        listView.setAdapter(myListAdapter);
    }

    public void LoadData() {
        list = new ArrayList<HashMap<String, String>>();
//        Creating HM
        HashMap<String, String> hashMap1 = new HashMap<String, String>();
//        Putting values in pre-defined Columns, defined above
        hashMap1.put(FIRST_COLUMN, "Ali");
        hashMap1.put(SECOND_COLUMN, "Ahmad");
        hashMap1.put(THIRD_COLUMN, "Saad");
        hashMap1.put(FOURTH_COLUMN, "Nabeel");
//        add to arraylist index 1
        list.add(hashMap1);

        HashMap<String, String> hashMap2 = new HashMap<String, String>();
//        Putting values in pre-defined Columns, defined above
        hashMap2.put(FIRST_COLUMN, "Ali2");
        hashMap2.put(SECOND_COLUMN, "Ahmad2");
        hashMap2.put(THIRD_COLUMN, "Saad2");
        hashMap2.put(FOURTH_COLUMN, "Nabeel2");
        list.add(hashMap2);

        HashMap<String, String> hashMap3 = new HashMap<String, String>();
//        Putting values in pre-defined Columns, defined above
        hashMap3.put(FIRST_COLUMN, "Ali3");
        hashMap3.put(SECOND_COLUMN, "Ahmad3");
        hashMap3.put(THIRD_COLUMN, "Saad3");
        hashMap3.put(FOURTH_COLUMN, "Nabeel3");
        list.add(hashMap3);

        HashMap<String, String> hashMap4 = new HashMap<String, String>();
//        Putting values in pre-defined Columns, defined above
        hashMap4.put(FIRST_COLUMN, "Ali4");
        hashMap4.put(SECOND_COLUMN, "Ahmad4");
        hashMap4.put(THIRD_COLUMN, "Saad4");
        hashMap4.put(FOURTH_COLUMN, "Nabeel4");
        list.add(hashMap4);

    }


}