package com.ouou.sooljari.admin.product.dto;

import com.ouou.sooljari.admin.product.entity.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductRequestDto {

    private String name;
    private String price;
    private String proof;
    private String area;
    private String description;

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .price(price)
                .proof(proof)
                .area(area)
                .description(description)
                .build();
    }


}
