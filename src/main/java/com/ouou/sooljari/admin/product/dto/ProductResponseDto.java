package com.ouou.sooljari.admin.product.dto;

import com.ouou.sooljari.admin.product.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponseDto {

    private Long id;
    private String name;
    private String category;
    private String image;
    private String price;
    private float proof;
    private String area;
    private String description;
    private int sweet;
    private int light;
    private int soft;
    private int bitter;
    private int clean;
    private int smell;

    public ProductResponseDto(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.category = entity.getCategory();
        this.image = entity.getImage();
        this.price = entity.getPrice();
        this.proof = entity.getProof();
        this.area = entity.getArea();
        this.description = entity.getDescription();
        this.sweet = entity.getSweet();
        this.light = entity.getLight();
        this.soft = entity.getSoft();
        this.bitter = entity.getBitter();
        this.clean = entity.getClean();
        this.smell = entity.getSmell();
    }
}
