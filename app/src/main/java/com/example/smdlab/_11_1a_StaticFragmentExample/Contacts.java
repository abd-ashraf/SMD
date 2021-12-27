package com.example.smdlab._11_1a_StaticFragmentExample;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.smdlab.R;

// instead of list adapter we use ListFragment
public class Contacts extends ListFragment {
//    communication with this interface will be done by mListener
    public ListSelectionListener mListener = null;

    public interface ListSelectionListener {
//        int id because we will list list id of clicked contact whose detail fragment we will shows
        public void onSelection(int position);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
//        to make interface work we make mListener assign context.
        mListener = (ListSelectionListener) getActivity();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.contact_textview,
                MyContactsMainActivity.contactsArray ));
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        getListView().setItemChecked(position, true);
        mListener.onSelection(position);
    }
}
