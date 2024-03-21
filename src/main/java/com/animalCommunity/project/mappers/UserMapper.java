package com.animalCommunity.project.mappers;


import com.animalCommunity.project.dtos.UserDto;
import com.animalCommunity.project.models.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    void addUser(User user);  //회원가입
    Optional<User> login(String userId);
    int exitMember(UserDto userDto);
}
