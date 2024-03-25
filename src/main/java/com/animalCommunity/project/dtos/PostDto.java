package com.animalCommunity.project.dtos;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class PostDto {
    private int uid;
    private int userUid;
}
