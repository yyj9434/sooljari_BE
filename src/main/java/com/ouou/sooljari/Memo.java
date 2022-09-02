package com.ouou.sooljari;

import javax.persistence.*;

@Entity
@Table(name = "tbl2")
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String memoTextselet;
}