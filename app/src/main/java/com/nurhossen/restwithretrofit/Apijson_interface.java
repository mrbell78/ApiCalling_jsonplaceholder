package com.nurhossen.restwithretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apijson_interface  {

    @GET("posts")
    Call<List<Post>> getPost();

    @GET("posts/1/comments")
    Call<List<Comment>> getComent();

}
