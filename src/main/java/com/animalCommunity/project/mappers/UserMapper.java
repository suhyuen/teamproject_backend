package com.animalCommunity.project.mappers;


import com.animalCommunity.project.dtos.UserDto;
import com.animalCommunity.project.models.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    void addUser(User user);  //회원가입
    UserDto idCheck(UserDto userDto); // id 중복체크
    UserDto nicknameCheck(UserDto userDto);
    Optional<User> login(String userId); //로그인
    int exitMember(UserDto userDto); //회원탈퇴
    User userInfo (User user); // 회원정보조회
    int userInfoUpdate (User user); //회원정보수정
}
