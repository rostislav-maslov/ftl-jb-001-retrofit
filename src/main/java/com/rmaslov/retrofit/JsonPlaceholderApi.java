package com.rmaslov.retrofit;

import com.rmaslov.retrofit.request.PostCreateRequest;
import com.rmaslov.retrofit.request.PostUpdateRequest;
import com.rmaslov.retrofit.response.AlbumResponse;
import com.rmaslov.retrofit.response.CommentResponse;
import com.rmaslov.retrofit.response.PostResponse;
import com.rmaslov.retrofit.response.UserResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface JsonPlaceholderApi {

    @GET("/posts")
    Call<List<PostResponse>> posts(@Query("userId") Integer userId);

    @POST("/posts")
    Call<PostResponse> postCreate(@Body PostCreateRequest request);

    @PUT("/posts/{id}")
    Call<PostResponse> postUpdate(@Path ("id") Integer id, @Body PostUpdateRequest request);

    @DELETE("/posts/{id}")
    Call<Void> postDelete(@Path ("id") Integer id);

    @GET("/posts/{id}")
    Call<PostResponse> postWithId(@Path ("id") Integer id);

    @GET("/posts/{id}/comments")
    Call<List<CommentResponse>> postComments(@Path ("id") Integer id);

    @GET("/users")
    Call<List<UserResponse>> users();

    @GET("/users/{userId}/albums")
    Call<List<AlbumResponse>> userAlbums(@Path("userId") Integer userId);

}
