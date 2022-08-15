package com.example.Login.dto;

import com.example.Login.entity.Member;
import com.example.Login.entity.Role;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {
    private String email;

    private String password;

    private String nickname;

    private String name;

    private String address;

    private String phone;

    private Role role;



    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}
