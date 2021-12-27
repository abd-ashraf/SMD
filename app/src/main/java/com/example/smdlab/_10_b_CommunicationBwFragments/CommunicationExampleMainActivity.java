package com.example.smdlab._10_b_CommunicationBwFragments;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.smdlab.R;

public class CommunicationExampleMainActivity extends FragmentActivity implements ButtonPressListener.onButtonPressListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication_example_main);

    }

    @Override
    public void onButtonPressed(String message) {
        SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.frag_2);
        secondFragment.onFragmentInteraction(message);

    }
}