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
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;   // 이부분과

    public void  CustomUserDetailsService(UserMapper userMapper){  // 이부분과
        this.userMapper = userMapper;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userMapper.findUser(username);
        return new CustomUserDetails(user.get());
    }
}
