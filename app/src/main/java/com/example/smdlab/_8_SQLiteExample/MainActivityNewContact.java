package com.example.smdlab._8_SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smdlab.R;

import java.util.HashMap;

public class MainActivityNewContact extends AppCompatActivity {
    DBTools dbTools;
    View view;
    EditText firstName, lastName, phoneNumber, emailAddress, homeAddress;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new_contact);
//        Our Contacts Db will be created after creating this dbTools object
        dbTools = new DBTools(getApplicationContext());
//        Snackbar.make(view, "Database OK", Snackbar.LENGTH_LONG).show();
        Toast.makeText(this, "DB Ok...", Toast.LENGTH_LONG).show();

//        Bind textViews
        firstName = findViewById(R.id.edtFirstName);
        lastName = findViewById(R.id.edtSecondName);
        phoneNumber = findViewById(R.id.edtPhoneNumber);
        emailAddress = findViewById(R.id.edtEmail);
        homeAddress = findViewById(R.id.edtHomeAddress);
//        bind button
        button = findViewById(R.id.btnSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Create Hashmap to store fields data
                HashMap<String, String> contact = new HashMap<String, String>();
                contact.put("firstName", firstName.getText().toString());
                contact.put("lastName", lastName.getText().toString());
                contact.put("phoneNumber", phoneNumber.getText().toString());
                contact.put("emailAddress", emailAddress.getText().toString());
                contact.put("homeAddress", homeAddress.getText().toString());
//                add our hashmap to dbTools
                dbTools.addNewContact(contact);

                Intent intent =  new Intent(getApplicationContext(),MainActivityContactList.class);
                startActivity(intent);
            }
        });
    }
}