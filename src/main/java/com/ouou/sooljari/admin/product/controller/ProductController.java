package com.ouou.sooljari.admin.product.controller;

import com.ouou.sooljari.admin.product.dto.ProductRequestDto;
import com.ouou.sooljari.admin.product.dto.ProductResponseDto;
import com.ouou.sooljari.admin.product.entity.Product;
import com.ouou.sooljari.admin.product.model.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
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
     * product 검색
     */
    @GetMapping("/products/{id}")
    public Optional<Product> findById(@PathVariable final Long id) {
        return productService.findById(id);
    }

    /**
     * product 수정
     */
    @PatchMapping("/products/{id}")
    public Long save(@PathVariable final Long id, @RequestBody final ProductRequestDto params) {
        return productService.update(id, params);
    }
}
