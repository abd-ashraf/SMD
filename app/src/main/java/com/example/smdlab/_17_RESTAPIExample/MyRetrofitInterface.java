package com.example.smdlab._17_RESTAPIExample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MyRetrofitInterface {
    @GET("posts")
    Call<List<MyRESTAPIModel>> getList();

//    hardcoded method
//    @GET("posts/1/comments")
//    Call<List<MyCommentsModel>> getComments();

//    dynamic method
//    @GET("posts/{id}/comments")
//    Call<List<MyCommentsModel>> getComments(@Path("id") int id);

//    wo wale comments do jiski id mai pass kru
//    @GET("comments")
//    Call<List<MyCommentsModel>> getComments(@Query("postId") int id);

//    sorting
//    @GET("comments")
//    Call<List<MyCommentsModel>> getComments(@Query("postId") int id,
//                                        @Query("_sort") String s,
//                                        @Query("_order") String sort);

//    now to POST data to API, now just call this line, pass data and it will store to api
    @POST("posts")
    Call<MyRESTAPIModel> createPost(@Body MyRESTAPIModel post);
}
