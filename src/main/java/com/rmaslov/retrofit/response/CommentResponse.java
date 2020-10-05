package com.rmaslov.retrofit.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentResponse {
    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;
}
