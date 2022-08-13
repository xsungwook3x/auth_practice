package com.example.security1.auth;

//시큐리티가 /login 낙아채서 로그인 진행시킴
//로그인을 진행이 완료가 되면 세션을 만들어줌(security contextholder)
// 오브젝트 => Authentication 타입 객체
//Authentication 안에 User 정보가 있어야함
//User 오브젝트 타입 => UserDetails 타입 객체

// 시큐리티 세션 영역 => Authentication => UserDetails

import com.example.security1.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {

    private User user;


    public PrincipalDetails(User user){
        this.user=user;
    }

    //해당 User의 권한을 리턴하는곳!
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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
        //우리 사이트 1년동안 회원이 로그인을 안하면 휴먼계정으로 전환
        // 현재시간 - 로그인시간 => 1년 초과하면 return false
        // 로그인 타임스탬프 열을 하나 만들어줘야함

        return true;
    }
}
