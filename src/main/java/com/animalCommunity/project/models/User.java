package com.animalCommunity.project.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    private int uid;
    private String username;
    private String nickname;
    private String userId;
    private String userPw;
    private String email;
    private String adress;
    private String animal;
    private String auth;
    private Date createAt;
    private String deleteYn;
}
