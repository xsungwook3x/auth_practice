package com.example.Login.service;

import com.example.Login.config.SecurityUtil;
import com.example.Login.dto.MemberDTO;
import com.example.Login.entity.Member;
import com.example.Login.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberDTO getMyInfoBySecurity() {
        Member member = memberRepository.findById(SecurityUtil.getCurrentMemberId()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));;

        MemberDTO memberDTO = new MemberDTO(member.getEmail(),member.getPassword(),member.getNickname(),member.getName(), member.getAddress(), member.getPhone(), member.getRole());

        return memberDTO;
    }

    @Transactional
    public void changeMemberInfo(String email, MemberDTO memberDTO) {
        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));

        member.setNickname(memberDTO.getNickname());
        member.setPhone(memberDTO.getPhone());
        member.setAddress(memberDTO.getAddress());

        memberRepository.save(member);
    }

    @Transactional
    public void changeMemberPassword(String email, String exPassword, String newPassword) {
        Member member = memberRepository.findById(SecurityUtil.getCurrentMemberId()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
        if (!passwordEncoder.matches(exPassword, member.getPassword())) {
            throw new RuntimeException("비밀번호가 맞지 않습니다");
        }
        member.setPassword(passwordEncoder.encode((newPassword)));
        memberRepository.save(member);
    }
}
