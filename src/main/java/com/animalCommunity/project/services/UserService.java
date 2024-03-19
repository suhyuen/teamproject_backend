package com.animalCommunity.project.services;

import com.animalCommunity.project.dtos.SignupDto;
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
    public void signup(SignupDto singupDto){
        User user = User.builder()
                .userId(singupDto.getUserId())
                .userPw(passwordEncoder.encode(singupDto.getUserPw()))
                .build();
        userMapper.addUser(user);
    }
}
