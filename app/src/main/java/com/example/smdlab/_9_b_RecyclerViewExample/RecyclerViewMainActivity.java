package com.example.smdlab._9_b_RecyclerViewExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.smdlab.R;

import java.util.ArrayList;

public class RecyclerViewMainActivity extends AppCompatActivity {
    private RecyclerView myRecyclerView;
    ArrayList<Mobiles> mobilesList;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);

        myRecyclerView = findViewById(R.id.myRecyclerView);

        mobilesList = new ArrayList<>();

        myAdapter = new MyAdapter(mobilesList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setItemAnimator(new DefaultItemAnimator());
        myRecyclerView.setAdapter(myAdapter);
        AddMobiles();
    }

    public void AddMobiles() {
        Mobiles mobiles = new Mobiles("Iphone 13", "Apple", "300k");
        mobilesList.add(mobiles);
        mobiles = new Mobiles("Note 12", "Apple", "300k");
        mobilesList.add(mobiles);
        mobiles = new Mobiles("Xperia 13", "Apple", "300k");
        mobilesList.add(mobiles);
        myAdapter.notifyDataSetChanged();
    }
}