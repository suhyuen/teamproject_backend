package com.animalCommunity.project.services;

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
    public int exitMember (UserDto userDto){
        return userMapper.exitMember(userDto); // 마이바티스는 쿼리가 정상처리되면 1을 반환한다.

    }
}
