package com.ouou.sooljari.admin.product.entity;

import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="product")
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String price;
    private String proof;
    private String area;
    private String description;

    @Builder
    public Product(String name, String price, String proof, String area, String description) {
        this.name = name;
        this.price = price;
        this.proof = proof;
        this.area = area;
        this.description = description;
    }

    public void update(String name, String price, String proof, String area, String description) {
        this.name = name;
        this.price = price;
        this.proof = proof;
        this.area = area;
        this.description = description;
    }
}
