package com.example.smdlab._10_b_CommunicationBwFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smdlab.R;

// we click in textbox in FirstFragment then a message is sent to interface -> mainactivity -> and displayed on SecondFragment in mainActivity
public class FirstFragment extends Fragment {
    ButtonPressListener.onButtonPressListener buttonPressListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.first_fragment, container, false);
        myFunction(root);
        return root;
    }

//    the onAttach() function attaches the view to fragment in mainActivity.
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        buttonPressListener = (ButtonPressListener.onButtonPressListener) getActivity();
    }

    void myFunction(ViewGroup root) {
        TextView textView = root.findViewById(R.id.fragmentText);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sending message to mainActivity via interface to display on secondFragment
                buttonPressListener.onButtonPressed("Message from First Fragment");
//                textView.setText("Message from First Fragment.");
            }
        });
    }
}
