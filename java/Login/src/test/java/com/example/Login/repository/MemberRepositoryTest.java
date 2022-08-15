package com.example.Login.repository;

import com.example.Login.entity.Member;
import com.example.Login.entity.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember(){
        Member member = new Member(null,"aaaa@naver.com","0000","김밍밍","밍밍","서울 어딘가","01000000000", Role.ROLE_USER,null);
        repository.save(member);

        Optional<Member> findMember = repository.findByEmail(member.getEmail());

        if(!findMember.isEmpty()) {

            assertEquals(findMember, member);
        }
    }




}