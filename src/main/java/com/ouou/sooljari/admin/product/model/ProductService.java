package com.ouou.sooljari.admin.product.model;

import com.ouou.sooljari.admin.product.dto.ProductRequestDto;
import com.ouou.sooljari.admin.product.dto.ProductResponseDto;
import com.ouou.sooljari.admin.product.entity.Product;
import com.ouou.sooljari.admin.product.entity.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.support.CustomSQLExceptionTranslatorRegistrar;
import org.springframework.jdbc.support.SQLErrorCodes;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    /**
     * product 생성
     */
    @Transactional
    public Long save(final ProductRequestDto params) {
        Product entity = productRepo.save(params.toEntity());
        return entity.getId();
    }

    /**
     * product 리스트 조회
     */
    public List<ProductResponseDto> findAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        List<Product> list = productRepo.findAll(sort);
        return list.stream().map(ProductResponseDto::new).collect(Collectors.toList());
    }

    /**
     * product id 검색
     */
    public Optional < Product > findById(Long id) {
        return productRepo.findById(id);
    }

    /**
     * product 수정
     */
    @Transactional
    public Long update(final Long id, final ProductRequestDto params) {
        Product entity = productRepo.findById(id).orElseThrow();
        entity.update(params.getName(), params.getCategory(), params.getImage(), params.getPrice(), params.getProof(), params.getArea(), params.getDescription());
        return id;
    }
}
