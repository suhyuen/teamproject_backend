package com.animalCommunity.project.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CommentDto {
    private int uid;
    private int userUid;
    private int postUid;
    private String content;
}
