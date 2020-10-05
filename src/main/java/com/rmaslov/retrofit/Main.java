package com.rmaslov.retrofit;

import com.rmaslov.retrofit.request.PostCreateRequest;
import com.rmaslov.retrofit.request.PostUpdateRequest;
import com.rmaslov.retrofit.response.AlbumResponse;
import com.rmaslov.retrofit.response.CommentResponse;
import com.rmaslov.retrofit.response.PostResponse;
import com.rmaslov.retrofit.response.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("START");
        JsonPlaceholderApi api = JsonPlaceholderService.getInstance().getJSONApi();

        System.out.println("------- POSTS ----------");
        List<PostResponse> posts = api.posts(null).execute().body();
        posts = api.posts(1).execute().body();
        System.out.println(posts.toString());

        System.out.println("------- POST CREATE ----------");
        PostResponse postCreate = api.postCreate(PostCreateRequest.builder()
                .userId(3)
                .title("New Post")
                .body("News")
                .build()).execute().body();
        System.out.println(postCreate);

        System.out.println("------- POST Update ----------");
        PostResponse postUpdate = api.postUpdate(1, PostUpdateRequest.builder()
                .id(1)
                .userId(3)
                .title("New Post")
                .body("News")
                .build()).execute().body();
        System.out.println(postUpdate);

        System.out.println("------- POST Delete ----------");
        Boolean postDelete = api.postDelete(1).execute().isSuccessful();
        System.out.println(postDelete);

        System.out.println("------- POST With ID ----------");
        PostResponse postWithId = api.postWithId(1).execute().body();
        System.out.println(postWithId);

        System.out.println("------- POST Comments ----------");
        List<CommentResponse> commentResponses = api.postComments(1).execute().body();
        System.out.println(commentResponses);

        System.out.println("------- Users ----------");
        List<UserResponse> userResponses = api.users().execute().body();
        System.out.println(userResponses);

        System.out.println("------- Users Albums----------");
        ;
        List<AlbumResponse> albumResponsesByUser = api.userAlbums(1).execute().body();
        System.out.println(albumResponsesByUser);

        Call<List<CommentResponse>> commentsCall = api.postComments(1);
        Response<List<CommentResponse>> commentsCallResponse = commentsCall.execute();
        if (commentsCallResponse.isSuccessful() && commentsCallResponse.code() == 200) {
            List<CommentResponse> responses = commentsCallResponse.body();
        } else {
            if (commentsCallResponse.code() == 400) {
                String error = commentsCallResponse.errorBody().string();
            } else if (commentsCallResponse.code() == 500) {
                String error = commentsCallResponse.errorBody().string();
            } else if (commentsCallResponse.code() == 403) {
                String error = commentsCallResponse.errorBody().string();
            }
        }

        for (int i = 0; i < 100; i++) {
            api.postComments(1).enqueue(new Callback<List<CommentResponse>>() {
                @Override
                public void onResponse(Call<List<CommentResponse>> call, Response<List<CommentResponse>> response) {
                    List<CommentResponse> comentAsyncResponse = response.body();
                }

                @Override
                public void onFailure(Call<List<CommentResponse>> call, Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        }

        System.out.println("passed");
    }

}
