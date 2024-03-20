package com.animalCommunity.project.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    private int uid;
    private String title;
    private String content;
    private int pageUid;
    private int mainUid;
    private LocalDateTime createdAt;
    private User user;
}
