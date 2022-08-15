package com.example.Login.config;

import com.example.Login.jwt.JwtFilter;
import com.example.Login.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final TokenProvider tokenProvider;

    @Override
    public void configure(HttpSecurity http) { // 직접만든 토크프로파이더와 jwt filter를 securityConfig에 적용할때 사용
        JwtFilter customFilter = new JwtFilter(tokenProvider);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }

    //메인 메소드인 configure은TokenProvider를 주입받아서 JwtFilter를 통해 SecurityConfig 안에 필터를 등록하게 되고, 스프링 시큐리티 전반적인 필터에 적용된다.

}
