package com.animalCommunity.project.services;

import com.animalCommunity.project.dtos.SignupDto;
import com.animalCommunity.project.dtos.UserDto;
import com.animalCommunity.project.mappers.UserMapper;
import com.animalCommunity.project.models.User;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserMapper userMapper;

    @Builder
    public void signup(UserDto userDto){  // 회원가입
        User user = User.builder()
                .username(userDto.getUsername())
                .nickname(userDto.getNickname())
                .userId(userDto.getUserId())
                .userPw(passwordEncoder.encode(userDto.getUserPw()))
                .email(userDto.getEmail())
                .adress(userDto.getAdress())
                .animal(userDto.getAnimal())
                .build();
        userMapper.addUser(user);
    }
    public String login(UserDto userDto){
        if(userMapper.login(userDto) != null){
            return "login ok";
        }else{
            return "login fail";
        }
    }
}
