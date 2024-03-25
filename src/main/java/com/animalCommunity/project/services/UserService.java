package com.animalCommunity.project.services;

import com.animalCommunity.project.dtos.UserDto;
import com.animalCommunity.project.mappers.UserMapper;
import com.animalCommunity.project.models.User;
import lombok.Builder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    PasswordEncoder passwordEncoder;
    UserMapper userMapper;

    public UserService(PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Builder(builderMethodName = "signupBuilder")  // 회원가입  // 빌더를 여러개 사용하려면 이름을 지어줘야 충돌하지 않는다.
    public int signup(UserDto userDto){
        User user = User.builder()
                .username(userDto.getUsername())
                .nickname(userDto.getNickname())
                .userId(userDto.getUserId())
                .userPw(passwordEncoder.encode(userDto.getUserPw()))
                .email(userDto.getEmail())
                .adress(userDto.getAdress())
                .animal(userDto.getAnimal())
                .build();
        if(userMapper.userInfo(user) == null){
            userMapper.addUser(user);
            return 1;
        }else{
            return 0;
        }
    }
    public int idCheck(UserDto userDto){  // 회원가입시 id 중복체크
        int idCheck = userMapper.idCheck(userDto)==null?0:1;
        return idCheck;
    }
    public int nicknameCheck(UserDto userDto){  // 회원가입시 nickname 중복체크
        int nicknameCheck = userMapper.nicknameCheck(userDto)==null?0:1;
         return nicknameCheck;
    }
    public int exitMember (UserDto userDto){ //회원탈퇴
        return userMapper.exitMember(userDto); // 마이바티스는 쿼리가 정상처리되면 1을 반환한다.
    }

    @Builder(builderMethodName = "userInfoBuilder")  // 회원정보조회
    public User userInfo (UserDto userDto) {
        User user = User.builder()
                .userId(userDto.getUserId())
                .build();
        User users = userMapper.userInfo(user);
        return users;
    }
    @Builder(builderMethodName = "userInfoUpdateBuilder")  //회원정보수정
    public int userInfoUpdate (UserDto userDto){
        User user = User.builder()
                .userId(userDto.getUserId())
                .username(userDto.getUsername())
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
                .adress(userDto.getAdress())
                .animal(userDto.getAnimal())
                .build();
        return userMapper.userInfoUpdate(user);
    }
    @Builder(builderMethodName = "findIdBuilder")
    public String findId(UserDto userDto){
        User user = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .build();
        String userId = userMapper.findId(user);
        return userId!=null?userId:"nullValue";
    }
}
