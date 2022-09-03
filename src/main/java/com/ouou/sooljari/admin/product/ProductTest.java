package com.ouou.sooljari.admin.product;

import com.ouou.sooljari.admin.product.entity.Product;
import com.ouou.sooljari.admin.product.entity.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ProductTest {

    @Autowired
    ProductRepo productRepo;

    @Test
    void save() {
        Product params = Product.builder()
                .name("test101")
                .price("23440")
                .proof("29")
                .area("seoul")
                .description("test101")
                .build();

        productRepo.save(params);

        Product entity = productRepo.findById((long) 7).orElse(null);
        assertThat(entity.getName()).isEqualTo("test101");
    }

    @Test
    void findAll() {
        long productCount = productRepo.count();

        List<Product> products = productRepo.findAll();
    }

    @Test
    void delete() {
        Product entity = productRepo.findById((long) 6).get();

        productRepo.delete(entity);
    }
}
