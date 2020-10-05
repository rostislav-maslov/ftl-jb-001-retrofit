package com.rmaslov.retrofit.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostCreateRequest {
    private Integer userId;
    private String title;
    private String body;
}
