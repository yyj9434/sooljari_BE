package com.ouou.sooljari.admin.product.dto;

import com.ouou.sooljari.admin.product.entity.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductRequestDto {

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

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .category(category)
                .image(image)
                .price(price)
                .proof(proof)
                .area(area)
                .description(description)
                .sweet(sweet)
                .light(light)
                .soft(soft)
                .bitter(bitter)
                .clean(clean)
                .smell(smell)
                .build();
    }


}
