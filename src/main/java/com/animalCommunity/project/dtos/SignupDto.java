package com.animalCommunity.project.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SignupDto {
    private String userId;
    private String userPw;
    private String nickname;
}
