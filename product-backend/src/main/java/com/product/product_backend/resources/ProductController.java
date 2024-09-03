package com.product.product_backend.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.product_backend.models.Product;

@RestController
public class ProductController {
    @GetMapping("product")
    public Product getProduct() {
        Product product = new Product();

        product.setId(1);
        product.setName("Banana");
        product.setPrice(22.30);

        return product;
    }

}
