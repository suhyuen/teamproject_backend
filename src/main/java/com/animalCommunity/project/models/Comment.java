package com.animalCommunity.project.models;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int uid;
    private int userUid;
    private int postUid;
    private String content;
    private Date createdAt;
    private char deleteyn;
    private User user;
}
