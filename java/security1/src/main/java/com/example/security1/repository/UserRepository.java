package com.example.security1.repository;

import com.example.security1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //이거 안붙여도 ioc됨 그이유는 상속을 하기때문
public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByUsername(String username);


}
