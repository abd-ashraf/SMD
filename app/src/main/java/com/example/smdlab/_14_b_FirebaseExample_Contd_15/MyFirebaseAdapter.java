package com.example.smdlab._14_b_FirebaseExample_Contd_15;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smdlab.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MyFirebaseAdapter extends RecyclerView.Adapter<MyFirebaseAdapter.ViewHolder> {
    ArrayList<FAST_Student> myList;
    Context context;

    public MyFirebaseAdapter(ArrayList<FAST_Student> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyFirebaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(myList.get(position).getName());
        Glide.with(context).load(myList.get(position).getURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View v) {
            super(v);
            imageView = v.findViewById(R.id.firebaseImageView);
            textView = v.findViewById(R.id.firebaseTextView);
        }

    }
}
