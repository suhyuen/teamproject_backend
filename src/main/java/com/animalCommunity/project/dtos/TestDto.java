package com.animalCommunity.project.dtos;

import com.animalCommunity.project.models.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
    private String testString;
    private int uid;
    private int userUid;
    private String title;
    private String content;
    private int pageUid;
    private int mainUid;
    private LocalDateTime createdAt;
    private int likeCount;
    private int commentCount;
}
