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
    private String proof;
    private String area;
    private String description;

    public ProductResponseDto(Product entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.category = entity.getCategory();
        this.image = entity.getImage();
        this.price = entity.getPrice();
        this.proof = entity.getProof();
        this.area = entity.getArea();
        this.description = entity.getDescription();
    }
}
