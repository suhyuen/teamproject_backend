package com.animalCommunity.project.services;

import com.animalCommunity.project.dtos.UserDto;
import com.animalCommunity.project.mappers.UserMapper;
import com.animalCommunity.project.models.User;
import lombok.Builder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public String idCheck(UserDto userDto){  // 회원가입시 id 중복체크
        String idCheck = userMapper.idCheck(userDto)==null?"ok":"error";
        return idCheck;
    }
    public String nicknameCheck(UserDto userDto){  // 회원가입시 nickname 중복체크
         return userMapper.nicknameCheck(userDto)==null?"ok":"error";
    }
    public String exitMember (UserDto userDto){ //회원탈퇴
        String returnCode = "error";
        Optional<User> user = userMapper.login(userDto.getUserId());
        if(passwordEncoder.matches(userDto.getUserPw(), user.get().getUserPw())){
            System.out.println(userDto);
            userMapper.exitMember(userDto);
            returnCode = "회원 탈퇴가 완료되었습니다.";
        }else{
            returnCode = "id / pw를 확인해주세요";
        }
        return returnCode;
    }

    @Builder(builderMethodName = "userInfoBuilder")  // 회원정보조회
    public User userInfo (String userId) {
        User user = User.builder()
                .userId(userId)
                .build();
        User users = userMapper.userInfo(user);
        return users;
    }
    @Builder(builderMethodName = "userInfoUpdateBuilder")  //회원정보수정
    public int userInfoUpdate (UserDto userDto){
        User user = User.builder()
                .userId((userDto.getUserId()))
                .nickname(userDto.getNickname())
                .email(userDto.getEmail())
                .adress(userDto.getAdress())
                .build();
        return userMapper.userInfoUpdate(user);
    }
    @Builder(builderMethodName = "findIdBuilder")
    public String findId(String username, String email){
        User user = User.builder()
                .username(username)
                .email(email)
                .build();
        String userId = userMapper.findId(user);
        return userId != null?userId : "nullValue";
    }
}
