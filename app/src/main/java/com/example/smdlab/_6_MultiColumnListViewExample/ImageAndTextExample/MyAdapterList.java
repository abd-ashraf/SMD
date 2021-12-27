package com.example.smdlab._6_MultiColumnListViewExample.ImageAndTextExample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smdlab.R;

public class MyAdapterList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] Name;
    private final String[] Text;
    private final int[] Image;

//    this constructor is made using alt+enter
    public MyAdapterList(@NonNull Context context, String[] name, String[] text, int[] image) {
        super(context, R.layout.imageandtextlistview, text);
        this.context = (Activity) context;
        Name = name;
        Text = text;
        Image = image;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View viewHolder = inflater.inflate(R.layout.imageandtextlistview, null);
        TextView name = viewHolder.findViewById(R.id.txtName);
        TextView text = viewHolder.findViewById(R.id.txtText);
        ImageView imageView = viewHolder.findViewById(R.id.imgListView);

        name.setText(Name[position]);
        text.setText(Text[position]);
        imageView.setImageResource(Image[position]);
        return viewHolder;

    }
}
