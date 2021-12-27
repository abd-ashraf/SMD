package com.example.smdlab._11_1a_StaticFragmentExample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smdlab.R;

public class ContactsDetail extends Fragment {
    public TextView contactDetailTextView;
    int currentIndex = -1;
    int arrayLength;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contacts_detail, container, false);
    }

    public int getShownIndex() {
        return currentIndex;
    }

    public void ContactIndex(int index) {
        if (index < 0 || index >= arrayLength) {
            return;
        }
        currentIndex = index;
        contactDetailTextView.setText(MyContactsMainActivity.contactsDetailArray[currentIndex]);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        we cant put direct findView... because this is java class and not actvity
        contactDetailTextView = getActivity().findViewById(R.id.txtContactsDetail);
        arrayLength = MyContactsMainActivity.contactsArray.length;
    }
}
