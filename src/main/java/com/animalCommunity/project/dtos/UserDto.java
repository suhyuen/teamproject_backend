package com.animalCommunity.project.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;
    private String nickname;
    private String userId;
    private String userPw;
    private String email;
    private String adress;
    private String animal;  // dog, cat, etc
}
