package com.example.smdlab._11_2_CardViewExample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smdlab.R;

import java.util.List;

public class My_CardView_Adapter extends RecyclerView.Adapter<My_CardView_Adapter.My_CardView_Holder> {
    public Context context;
    List<My_Model> modelList;

    public My_CardView_Adapter(Context context, List<My_Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public My_CardView_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_card, parent, false);
        return new My_CardView_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull My_CardView_Holder holder, int position) {
//        get img, text and count from position element
        My_Model my_model = modelList.get(position);
        holder.title.setText(my_model.getName());
        holder.count.setText(my_model.getThumbnails());
        Glide.with(context).load(my_model.getThumbnails()).into(holder.myCardImageView);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class My_CardView_Holder extends RecyclerView.ViewHolder {
        TextView title, count;
        ImageView myCardImageView;
        public My_CardView_Holder(@NonNull View view) {
            super(view);
            title = view.findViewById(R.id.my_cardText1);
            count = view.findViewById(R.id.my_cardText2);
            myCardImageView = view.findViewById(R.id.my_cardImage);
        }
    }
}
