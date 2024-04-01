package com.animalCommunity.project.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WriteDto {
    private int uid;
    private int userUid;
    private int pageUid;
    private int mainUid;
    private String title;
    private String content;
}
