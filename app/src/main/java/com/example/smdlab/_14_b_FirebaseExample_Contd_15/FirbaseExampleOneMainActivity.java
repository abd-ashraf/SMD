package com.example.smdlab._14_b_FirebaseExample_Contd_15;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.smdlab.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirbaseExampleOneMainActivity extends AppCompatActivity {
    DatabaseReference myReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firbase_example_one_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://myfirstproject-9c793-default-rtdb.firebaseio.com/");
        myReference = database.getReference();
//        myReference.setValue("AbuBakr is a good boy.");
//        myReference.child("SMD").child("Student").setValue("Molvi");
//        myReference.child("SMD").child("Student2").setValue("Molvi the second");

    }

    public void AddValuesToFirebase(View view) {
        myReference.child("BSCS").child("SMD").child("Stu 1").setValue("Ali");
        myReference.child("BSCS").child("IS").child("Stu 1").setValue("Ali");
    }

    public void RemoveValues(View view) {
        myReference.removeValue();
    }

    public void RetrieveValues(View view) {
//        implement listener
        myReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String which will read data
//                all db values are present in DataSnapshot class
                if (dataSnapshot.getValue() != null) {
//                    for each loop, it will assign dataSnapshot children to snapshot
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String Value = snapshot.getValue().toString();
                        Log.d("TAG", "" + Value);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}