package com.animalCommunity.project.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {

    int uid;
    int userUid;
    int pageUid;
    String title;
    String content;

}
