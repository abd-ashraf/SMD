package com.example.smdlab._10_b_CommunicationBwFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smdlab.R;

public class SecondFragment extends Fragment {
    TextView textView;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.first_fragment, container, false);
        return view;
    }

//    this function will run when we click on firstFragment in mainActivity and
//    will display message that was sent from firstFragment
    public void onFragmentInteraction(String message) {
        textView = view.findViewById(R.id.fragmentText);
        textView.setText(message);
    }
}
