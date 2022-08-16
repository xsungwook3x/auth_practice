package com.example.Login.controller;

import com.example.Login.dto.MemberDTO;
import com.example.Login.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<?> getMyMemberInfo(){
        MemberDTO myInfoBySecurity = memberService.getMyInfoBySecurity();
        return ResponseEntity.ok(myInfoBySecurity);
    }

    @PostMapping("/info")
    public ResponseEntity<?> setMemberInfo(@RequestBody MemberDTO memberDTO){
        memberService.changeMemberInfo(memberDTO.getEmail(),memberDTO);
        return ResponseEntity.ok("수정 성공!");
    }

    @PostMapping("/password")
    public ResponseEntity<?> setMemberPassword(@RequestBody String email,@RequestBody String exPassword,@RequestBody String newPassword){
        memberService.changeMemberPassword(email,exPassword,newPassword);
        return ResponseEntity.ok("비밀번호 수정 성공!");
    }
}
