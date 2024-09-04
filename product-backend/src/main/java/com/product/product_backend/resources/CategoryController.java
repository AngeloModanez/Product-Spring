package com.product.product_backend.resources;

import com.product.product_backend.models.Category;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CategoryController {

    private List<Category> categories = Arrays.asList(
            new Category(1, "Electronics"),
            new Category(2, "Food"));

    @GetMapping("categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable int id) {
        Category cat = categories.stream().filter(c -> c.getId() == id).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        return ResponseEntity.ok(cat);
    }

    @GetMapping("categories")
    public List<Category> getCategories() {
        return categories;
    }

}
