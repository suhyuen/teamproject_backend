package com.animalCommunity.project.authentication;

import com.animalCommunity.project.mappers.UserMapper;
import com.animalCommunity.project.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;   // 이부분과

    public CustomUserDetailService(UserMapper userMapper){  // 이부분과
        this.userMapper = userMapper;
    }
    @Override
    public CustomUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userMapper.login(username);
        return new CustomUserDetail(user.get());
    }
}
