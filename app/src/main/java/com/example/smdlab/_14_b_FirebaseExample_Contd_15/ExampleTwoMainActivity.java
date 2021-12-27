package com.example.smdlab._14_b_FirebaseExample_Contd_15;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.smdlab.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ExampleTwoMainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference reference;
    FirebaseDatabase database;
//    make array to store data from db
    ArrayList<FAST_Student> myList;
    MyFirebaseAdapter myFirebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_two_main);

        recyclerView = findViewById(R.id.firebaseRecyclerView);



//        db connection
        database = FirebaseDatabase.getInstance("https://myfirstproject-9c793-default-rtdb.firebaseio.com/");
//        pass parentNode name, otherwise if we dont pass it will also work.
        reference = database.getReference("Student");
        myList = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        LoadData();

    }

    public void LoadData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    FAST_Student fast_student = new FAST_Student();
                    fast_student.setName(snapshot.child("Name").getValue().toString());
                    fast_student.setURL(snapshot.child("Picture").getValue().toString());
                    myList.add(fast_student);
                }
                myFirebaseAdapter = new MyFirebaseAdapter(myList, getApplicationContext());
                recyclerView.setAdapter(myFirebaseAdapter);
                myFirebaseAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void Clear() {
        if (myList != null) {
            myList.clear();
            if (myFirebaseAdapter != null) {
                myFirebaseAdapter.notifyDataSetChanged();
            }
            else
                myList = new ArrayList<>();
        }
    }
}

//broadcast kis type ka ho skta, broadcast receiver IMP Q fro exam