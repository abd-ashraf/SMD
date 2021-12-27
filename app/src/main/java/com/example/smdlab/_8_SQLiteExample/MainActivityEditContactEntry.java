package com.example.smdlab._8_SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.smdlab.R;

import java.util.HashMap;

public class MainActivityEditContactEntry extends AppCompatActivity {
    EditText firstName, lastName, phoneNumber, emailAddress, homeAddress;
    DBTools dbTools;
    String id = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_edit_contact_entry);

        firstName = findViewById(R.id.editFirstName);
        lastName = findViewById(R.id.editSecondName);
        phoneNumber = findViewById(R.id.editPhoneNumber);
        emailAddress = findViewById(R.id.editEmail);
        homeAddress = findViewById(R.id.editHomeAddress);

        dbTools = new DBTools(getApplicationContext());

        Intent intent = getIntent();
//        another method of extracting data from intent
        id = intent.getExtras().getString("_id");
//        calling function in dbTools and passing id as argument
        HashMap<String, String> singleRecord = dbTools.getSingleRecord(id);
        if (singleRecord.size() != 0) {
            firstName.setText(singleRecord.get("firstName"));
            lastName.setText(singleRecord.get("lastName"));
            phoneNumber.setText(singleRecord.get("phoneNumber"));
            emailAddress.setText(singleRecord.get("emailAddress"));
            homeAddress.setText(singleRecord.get("homeAddress"));
        }

    }

    public void UpdateRecord(View view) {
        firstName = findViewById(R.id.editFirstName);
        lastName = findViewById(R.id.editSecondName);
        phoneNumber = findViewById(R.id.editPhoneNumber);
        emailAddress = findViewById(R.id.editEmail);
        homeAddress = findViewById(R.id.editHomeAddress);

        String fName, lName, pNumber, email, address;
        fName = firstName.getText().toString();
        lName = lastName.getText().toString();
        pNumber = phoneNumber.getText().toString();
        email = emailAddress.getText().toString();
        address = homeAddress.getText().toString();

        ContentValues contentValues = new ContentValues();
        if (!fName.matches("")){
            contentValues.put("firstName", fName);
        }
        if (!lName.matches("")) {
            contentValues.put("lastName", lName);
        }
        if (!pNumber.matches("")) {
            contentValues.put("phoneNumber", pNumber);
        }
        if (!email.matches("")) {
            contentValues.put("emailAddress", email);
        }
        if (!address.matches("")) {
            contentValues.put("homeAddress", address);
        }

        dbTools.UpdateRecord(id, contentValues);

        Intent intent =  new Intent(getApplicationContext(), MainActivityContactList.class);
        startActivity(intent);
    }

    public void DeleteRecord(View view) {
        dbTools.DeleteRecord(id);

        Intent intent =  new Intent(getApplicationContext(), MainActivityContactList.class);
        startActivity(intent);
    }
}