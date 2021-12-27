package com.example.smdlab._11_1a_StaticFragmentExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smdlab.R;

public class MyContactsMainActivity extends AppCompatActivity implements Contacts.ListSelectionListener {
    public static String[] contactsArray;
    public static String[] contactsDetailArray;
    public ContactsDetail contactsDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contacts_main);

//        because we want to get array from strings.xml in /res directory
        contactsArray = getResources().getStringArray(R.array.contacts_array);
        contactsDetailArray = getResources().getStringArray(R.array.detail_array);

//        headless fragments are accessed by ..ByTag()
        contactsDetailFragment = (ContactsDetail) getSupportFragmentManager().findFragmentById(R.id.contactsDetail);

    }

    @Override
    public void onSelection(int id) {
        if (contactsDetailFragment.getShownIndex() != id) {
            contactsDetailFragment.ContactIndex(id);
        }
    }
}