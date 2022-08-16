package com.example.Login.service;

import com.example.Login.dto.MemberDTO;
import com.example.Login.dto.TokenDTO;
import com.example.Login.entity.Member;
import com.example.Login.jwt.TokenProvider;
import com.example.Login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final AuthenticationManagerBuilder managerBuilder;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    public void signup(MemberDTO memberDTO){
        if(memberRepository.existsByEmail(memberDTO.getEmail())){
            throw new RuntimeException("이미 가입되어있습니다.");
        }
        String tmpPassword = passwordEncoder.encode(memberDTO.getPassword());//인코딩
        Member member = new Member(null,memberDTO.getEmail(),tmpPassword, memberDTO.getName(),memberDTO.getNickname(),memberDTO.getAddress(),memberDTO.getPhone(),memberDTO.getRole(),null );
        memberRepository.save(member);

    }

    public TokenDTO login(String email,String password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email,password);

        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);

        return tokenProvider.generateTokenDto(authentication);
    }
}
