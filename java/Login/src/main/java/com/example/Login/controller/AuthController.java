package com.example.Login.controller;

import com.example.Login.dto.MemberDTO;
import com.example.Login.dto.TokenDTO;
import com.example.Login.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody MemberDTO memberDTO){
        service.signup(memberDTO);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody String email,@RequestBody String password){
        return ResponseEntity.ok(service.login(email,password));
    }
}
