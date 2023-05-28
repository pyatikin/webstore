package com.sipi.webstore.controllers;

import com.sipi.webstore.models.Product;
import com.sipi.webstore.services.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class Products {

    private final ProductService productService;

    public Products(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts()
    {
        return productService.getAllProducts();
    }
}
