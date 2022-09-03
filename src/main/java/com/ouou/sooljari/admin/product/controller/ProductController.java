package com.ouou.sooljari.admin.product.controller;

import com.ouou.sooljari.admin.product.dto.ProductRequestDto;
import com.ouou.sooljari.admin.product.dto.ProductResponseDto;
import com.ouou.sooljari.admin.product.model.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    /**
     * product 생성
     */
    @PostMapping("/products")
    public Long save(@RequestBody final ProductRequestDto params) {
        return productService.save(params);
    }

    /**
     * product 조회
     */
    @GetMapping("/products")
    public List<ProductResponseDto> findAll() {
        return productService.findAll();
    }

    /**
     * product 수정
     */
    @PatchMapping("/products/{id}")
    public Long save(@PathVariable final Long id, @RequestBody final ProductRequestDto params) {
        return productService.update(id, params);
    }
}
