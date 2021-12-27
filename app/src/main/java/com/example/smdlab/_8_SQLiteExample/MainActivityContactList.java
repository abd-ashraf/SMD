package com.example.smdlab._8_SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.smdlab.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivityContactList extends AppCompatActivity {
    ListView listView;
    DBTools dbTools;
    TextView contactID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contact_list);
//        bind listView
        listView = findViewById(R.id.listMainContact);

        dbTools = new DBTools(getApplicationContext());

//        Called function to get all contacts
        ArrayList<HashMap<String, String>> AllContacts = dbTools.getAllContacts();
//        to see if db is not empty
        if (AllContacts.size() != 0) {
            SimpleAdapter simpleAdapter = new SimpleAdapter(this, AllContacts,
                    R.layout.activity_main_contact_entryy,
                    new String[] {"_id", "firstName", "lastName"},
                    new int[]{R.id.textViewID, R.id.textViewFirstName, R.id.textViewLastName});
            listView.setAdapter(simpleAdapter);
        }



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MainActivityEditContactEntry.class);
    //        binding TextViews
                contactID = view.findViewById(R.id.textViewID);
                intent.putExtra("_id", contactID.getText().toString());
                startActivity(intent);
            }
        });

    }

    public void AddContact(View view) {
        Intent intent = new Intent(this, MainActivityNewContact.class);
        startActivity(intent);
    }
}