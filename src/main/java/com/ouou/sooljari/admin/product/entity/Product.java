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
    private String category;
    private String image;
    private String price;
    private float proof;
    private String area;
    private String description;

    @Builder
    public Product(String name, String category, String image, String price, float proof, String area, String description) {
        this.name = name;
        this.category = category;
        this.image = image;
        this.price = price;
        this.proof = proof;
        this.area = area;
        this.description = description;
    }

    public void update(String name, String category, String image, String price, float proof, String area, String description) {
        this.name = name;
        this.category = category;
        this.image = image;
        this.price = price;
        this.proof = proof;
        this.area = area;
        this.description = description;
    }
}
