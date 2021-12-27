package com.example.smdlab._17_RESTAPIExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.smdlab.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRESTMainActivity extends AppCompatActivity {
    MyRetrofitInterface apiInterface;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_restmain);
//        recyclerView
        recyclerView = findViewById(R.id.myRESTRecyclerView);

//        initialise interface - globally
        apiInterface = MyRetrofit.getMyRetrofit().create(MyRetrofitInterface.class);

//        getList();
//        getComments();
        CreatePost();
    }

    public void CreatePost() {
        MyRESTAPIModel post = new MyRESTAPIModel(5, "Post Title", "Post Body");
        apiInterface.createPost(post);
        Call<MyRESTAPIModel> myPost = apiInterface.createPost(post);
        myPost.enqueue(new Callback<MyRESTAPIModel>() {
            @Override
            public void onResponse(Call<MyRESTAPIModel> call, Response<MyRESTAPIModel> response) {
                if (response.isSuccessful()) {
                    Log.d("TAG", " " + response.body().getTitle() + " " + response.body().getBody());
                }
            }

            @Override
            public void onFailure(Call<MyRESTAPIModel> call, Throwable t) {

            }
        });
    }

//    private void getList() {
////        if we run our app on main thread we call enqueue, if we run on bg then we call execute
//        apiInterface.getList().enqueue(new Callback<List<MyRESTAPIModel>>() {
//            @Override
//            public void onResponse(Call<List<MyRESTAPIModel>> call, Response<List<MyRESTAPIModel>> response) {
//                if (response.body().size() > 0) {
////                    recyclerView ka kaam idhr, to show data
//                    List<MyRESTAPIModel> list = response.body();
//                    MyRESTAdapter adapter = new MyRESTAdapter(list, getApplicationContext());
////                    ye adapter linearly data show krega so we'll use linear layout manager
//                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//                    recyclerView.setLayoutManager(linearLayoutManager);
//                    recyclerView.setAdapter(adapter);
//
//                    Toast.makeText(MyRESTMainActivity.this, "Data Retrieved", Toast.LENGTH_SHORT).show();
//                }
//                else
//                    Toast.makeText(MyRESTMainActivity.this, "List is Empty", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<List<MyRESTAPIModel>> call, Throwable t) {
//                Toast.makeText(MyRESTMainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void getComments() {
//        Call<List<MyCommentsModel>> commentsList = apiInterface.getComments(2, "id", "desc");
//        commentsList.enqueue(new Callback<List<MyCommentsModel>>() {
//            @Override
//            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
//                if (response.isSuccessful()) {
//                    for (MyCommentsModel comments : response.body()) {
//                        Log.d("TAG", "id: " + comments.getId() + " | postId: " + comments.getPostId()
//                        + " | name: " + comments.getName());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {
//
//            }
//        });
//    }
}