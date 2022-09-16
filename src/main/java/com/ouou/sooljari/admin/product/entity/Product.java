package com.ouou.sooljari.admin.product.entity;

import lombok.*;

import javax.persistence.*;

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
    private String image;
    private String price;
    private String proof;
    private String area;
    private String description;

    @Builder
    public Product(String name, String image, String price, String proof, String area, String description) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.proof = proof;
        this.area = area;
        this.description = description;
    }

    public void update(String name, String image, String price, String proof, String area, String description) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.proof = proof;
        this.area = area;
        this.description = description;
    }
}
