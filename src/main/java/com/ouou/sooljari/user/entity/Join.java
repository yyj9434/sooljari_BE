package com.ouou.sooljari.user.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user")
@Builder
public class Join {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;
    private String password;
    private String userName;
    private String birth;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Join(String email, String password, String userName, String birth, String phone, Authority authority) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.birth = birth;
        this.phone = phone;
        this.authority = authority;
    }
}