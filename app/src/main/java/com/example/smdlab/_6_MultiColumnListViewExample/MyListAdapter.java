package com.example.smdlab._6_MultiColumnListViewExample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.smdlab.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MyListAdapter extends BaseAdapter {
    public static final String FIRST_COLUMN = "First";
    public static final String SECOND_COLUMN = "Second";
    public static final String THIRD_COLUMN = "Third";
    public static final String FOURTH_COLUMN = "Fourth";
    public ArrayList<HashMap<String, String>> list;
    Activity activity;

//    by Control + fn + enter in mac
//    Constructor
    public MyListAdapter(ArrayList<HashMap<String, String>> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

//  int i = position
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
//        we make view holder to hold hm values and connect to textview columns in other activity
        LayoutInflater inflater = activity.getLayoutInflater();
        ViewHolder viewHolder = new ViewHolder();
        if (view == null) {
            view = inflater.inflate(R.layout.multirowlistview, null);
            viewHolder.textView1 = view.findViewById(R.id.txtCol1);
            viewHolder.textView2 = view.findViewById(R.id.txtCol2);
            viewHolder.textView3 = view.findViewById(R.id.txtCol3);
            viewHolder.textView4 = view.findViewById(R.id.txtCol4);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap = list.get(position);
        viewHolder.textView1.setText(hashMap.get(FIRST_COLUMN));
        viewHolder.textView2.setText(hashMap.get(SECOND_COLUMN));
        viewHolder.textView3.setText(hashMap.get(THIRD_COLUMN));
        viewHolder.textView4.setText(hashMap.get(FOURTH_COLUMN));

        return view;
    }

    private class ViewHolder{
        TextView textView1, textView2, textView3, textView4;
    }
}
