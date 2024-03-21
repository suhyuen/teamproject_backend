package com.animalCommunity.project.models;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class Admin {
    private int uid;
    private int userUid;
    private int pageUid;
    private String title;
    private String content;
    private int viewer;
    private Date createdAt;
    private String deleteyn;
}
