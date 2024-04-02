package com.animalCommunity.project.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private int uid;
    private int userUid;
    private String nickname;
    private int pageUid;
    private int mainUid;
    private String title;
    private String content;
    private int viewer;
    private Date createdAt;
    private String deleteyn;

}
