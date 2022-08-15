package com.example.Login.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty
    private String email;

    @Column
    @NotEmpty
    private String password;

    @Column
    @NotEmpty
    private String name;

    @Column
    @NotEmpty
    private String nickname;

    @Column
    @NotEmpty
    private String address;

    @Column
    @NotEmpty
    private String phone;



    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @CreationTimestamp
    private Timestamp createDate;


}
