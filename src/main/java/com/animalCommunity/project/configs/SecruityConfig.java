package com.animalCommunity.project.configs;

import com.animalCommunity.project.authentication.JwtAuthenticationFilter;
import com.animalCommunity.project.authentication.LoginAuthenticationFilter;
import com.animalCommunity.project.authentication.UserNamePasswordAuthenticationProvider;
import com.animalCommunity.project.utils.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecruityConfig {
    private final JwtUtil jwtUtil;
    private final UserNamePasswordAuthenticationProvider userNamePasswordAuthenticationProvider;

    public SecruityConfig(JwtUtil jwtUtil, UserNamePasswordAuthenticationProvider userNamePasswordAuthenticationProvider) {
        this.jwtUtil = jwtUtil;
        this.userNamePasswordAuthenticationProvider = userNamePasswordAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http)throws Exception{
        http.formLogin((formLogin) -> formLogin.disable());
        http.httpBasic((httpBasic) -> httpBasic.disable());
        http.csrf((csrf) -> csrf.disable());
        http.addFilterAt(new LoginAuthenticationFilter(jwtUtil, authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtAuthenticationFilter(jwtUtil), LoginAuthenticationFilter.class);

        http.authorizeHttpRequests(authz -> authz  // 요청에 대한 인증
                .requestMatchers(HttpMethod.GET,"/getTest").permitAll()
                .requestMatchers(HttpMethod.POST,"/postTest2").permitAll()
                .requestMatchers(HttpMethod.POST,"/signup").permitAll()
                .requestMatchers(HttpMethod.POST,"/login").permitAll()
                .requestMatchers(HttpMethod.POST,"/exitMember").hasAnyAuthority("ROLE_USER")
                .requestMatchers(HttpMethod.POST,"/userInfo").hasAnyAuthority("ROLE_USER")
                .anyRequest().authenticated());
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception{
        return new ProviderManager(userNamePasswordAuthenticationProvider);
    }
}
