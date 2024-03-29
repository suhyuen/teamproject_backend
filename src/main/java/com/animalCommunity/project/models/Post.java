package com.animalCommunity.project.models;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int uid;
    private int userUid;
    private String title;
    private String content;
    private String mainName;
    private String pageName;
    private int pageUid;
    private int mainUid;
    private LocalDateTime createdAt;
    private int likeCount;
    private int commentCount;
    private int viewer;
    private User user;

}
