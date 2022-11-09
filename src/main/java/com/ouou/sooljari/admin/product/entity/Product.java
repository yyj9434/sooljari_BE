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

    @Column(name="sweet" , columnDefinition = "TINYINT", length = 1)
    private int sweet;

    @Column(name="light" , columnDefinition = "TINYINT", length = 1)
    private int light;

    @Column(name="soft" , columnDefinition = "TINYINT", length = 1)
    private int soft;

    @Column(name="bitter" , columnDefinition = "TINYINT", length = 1)
    private int bitter;

    @Column(name="clean" , columnDefinition = "TINYINT", length = 1)
    private int clean;

    @Column(name="smell" , columnDefinition = "TINYINT", length = 1)
    private int smell;



    @Builder
    public Product(String name, String category, String image, String price, float proof, String area, String description, int sweet, int light, int soft, int bitter, int clean, int smell) {
        this.name = name;
        this.category = category;
        this.image = image;
        this.price = price;
        this.proof = proof;
        this.area = area;
        this.description = description;
        this.sweet = sweet;
        this.light = light;
        this.soft = soft;
        this.bitter = bitter;
        this.clean = clean;
        this.smell = smell;
    }

    public void update(String name, String category, String image, String price, float proof, String area, String description, int sweet, int light, int soft, int bitter, int clean, int smell) {
        this.name = name;
        this.category = category;
        this.image = image;
        this.price = price;
        this.proof = proof;
        this.area = area;
        this.description = description;
        this.sweet = sweet;
        this.light = light;
        this.soft = soft;
        this.bitter = bitter;
        this.clean = clean;
        this.smell = smell;
    }
}
