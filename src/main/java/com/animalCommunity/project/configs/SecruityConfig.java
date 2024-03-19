package com.animalCommunity.project.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecruityConfig {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http)throws Exception{ //여러가지 필터에 대한 셋팅을 진행하는 클래스
        http.formLogin((formLogin)->formLogin.disable()); //
        http.httpBasic((httpBasic)->httpBasic.disable()); //
        http.csrf((csrf) -> csrf.disable()); //

        return http.build(); // http.build()메서드를 실행하면 위에 설정한 필터 그대로 객체가 생성된다.
    }
}
