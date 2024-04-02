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
    int mainUid;
    String title;
    String content;

    public void setUserUid(int userUid) {
        this.userUid = userUid;
    }
}
