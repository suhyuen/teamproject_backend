package com.animalCommunity.project.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class User {
    private int uid;
    private String name;
    private String nickname;
    private String userId;
    private String userPw;
    private String email;
    private String address;
    private String animal;
    private String role;
    private Date createAt;
    private String deleteYn;
}
