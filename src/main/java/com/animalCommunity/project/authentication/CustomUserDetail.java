package com.animalCommunity.project.authentication;

import com.animalCommunity.project.models.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Getter
public class CustomUserDetail implements UserDetails {

    private int uid;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetail(User user) {
        this.uid = user.getUid();
        this.username = user.getUserId();
        this.password = user.getUserPw();
        this.authorities = List.of(() -> user.getAuth());
//        for (GrantedAuthority authority : authorities) {
//            System.out.println("Authority: " + authority.getAuthority());
//        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
