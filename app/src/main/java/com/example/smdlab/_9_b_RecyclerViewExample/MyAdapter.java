package com.example.smdlab._9_b_RecyclerViewExample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smdlab.R;

import java.util.ArrayList;

// extend this class with recycler view with the type thats defined in this class
//parentClass.innerClass
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<Mobiles> mobilesArrayList;
    private String[] myData;

    public MyAdapter(ArrayList<Mobiles> mobilesArrayList) {
        this.mobilesArrayList = mobilesArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobile_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mobiles mobiles = mobilesArrayList.get(position);
        holder.MobileName.setText(mobiles.getName());
        holder.MobileCompany.setText(mobiles.getCompany());
        holder.MobilePrice.setText(mobiles.getPrice());
    }

    @Override
    public int getItemCount() {
        return mobilesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView MobileName, MobileCompany, MobilePrice;
        public ViewHolder(@NonNull View View) {
            super(View);

            MobileName = View.findViewById(R.id.txtMobileName);
            MobileCompany = View.findViewById(R.id.txtCompanyName);
            MobilePrice = View.findViewById(R.id.txtMobilePrice);
        }
    }
}
