package com.animalCommunity.project.dtos;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WriteDto {
    private int uid;
    private int userUid;
    private int pageUid;
    private int mainUid;
    private String title;
    private String content;
}
