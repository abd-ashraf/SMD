package com.example.smdlab._11_2_CardViewExample;

import android.graphics.Rect;
import android.os.Bundle;

import com.example.smdlab.R;
import com.example.smdlab.databinding.ActivityScrollingMainBinding;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;
//import com.example.smdlab.CardViewExample.databinding.ActivityScrollingMainBinding;

public class ScrollingActivityMain extends AppCompatActivity {
    private ActivityScrollingMainBinding binding;

    public List<My_Model> my_modelList;
    public My_CardView_Adapter my_cardView_adapter;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityScrollingMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        recyclerView = findViewById(R.id.myCardViewRecycler);
        my_modelList = new ArrayList<>();
        my_cardView_adapter = new My_CardView_Adapter(this, my_modelList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridSpace(2, 10, true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(my_cardView_adapter);
        Insert();
    }

    public class GridSpace extends RecyclerView.ItemDecoration {
        int count, spacing;
        boolean edgeInclude;

        public GridSpace(int count, int spacing, boolean edgeInclude) {
            this.count = count;
            this.spacing = spacing;
            this.edgeInclude = edgeInclude;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            int itemPosition = parent.getChildAdapterPosition(view);
            int itemColumn = itemPosition % count;
            if (edgeInclude) {
                outRect.left = spacing - itemColumn * spacing/count;
                outRect.right = (itemColumn+1) * spacing/count;

                if (itemPosition < count) {
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            }
        }

    }

//    public int ConvertDpToPix(int dp) {
//        Resources resources =
//    }

    public void Insert() {
        int[] myImages = new int[] {
                R.drawable.brooklyn, R.drawable.chicago,
                R.drawable.city, R.drawable.blue,
                R.drawable.canyon, R.drawable.canyon
        };
        My_Model my_model = new My_Model("My First Card View", 10, myImages[0]);
        my_modelList.add(my_model);
        my_model = new My_Model("My Second Card View", 100, myImages[1]);
        my_modelList.add(my_model);
        my_model = new My_Model("My Third Card View", 100, myImages[2]);
        my_modelList.add(my_model);
        my_model = new My_Model("My Fourth Card View", 100, myImages[3]);
        my_modelList.add(my_model);
        my_model = new My_Model("My Fifth Card View", 100, myImages[4]);
        my_modelList.add(my_model);
        my_model = new My_Model("My Sixth Card View", 100, myImages[5]);
        my_modelList.add(my_model);

//        cloud se data will come in card view
//        list se data will come in recycler view

    }

}