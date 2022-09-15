//package com.ouou.sooljari;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Getter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name="user")
//@Builder
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String account;
//    private String email;
//    private String phoneNumber;
//
//    @Column(nullable = false)
//    private LocalDateTime createdAt;
//
//    @Column(nullable = false)
//    private String createdBy;
//    private LocalDateTime updateAt;
//    private String updatedBy;
//}