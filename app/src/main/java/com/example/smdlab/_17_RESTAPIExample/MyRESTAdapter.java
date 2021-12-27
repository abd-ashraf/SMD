package com.example.smdlab._17_RESTAPIExample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smdlab.R;

import java.util.List;

public class MyRESTAdapter extends RecyclerView.Adapter<MyRESTAdapter.ViewHolder> {
    public List<MyRESTAPIModel> list;
    public Context context;

    public MyRESTAdapter(List<MyRESTAPIModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        this will bind layout
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.my_rest_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        jab layout bind hojay
//        getTitle() / getBody() is coming from modelClass
        holder.Name.setText(list.get(position).getTitle());
        holder.Content.setText(list.get(position).getBody());
    }

    @Override
    public int getItemCount() {
//        jo list upr ai, uska size return
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
//        we will bind textViews here
        TextView Name, Content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.restTextName);
            Content = itemView.findViewById(R.id.restTxtContent);
        }
    }
}
