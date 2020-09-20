package ru.balmukanov.productmarket.controller;

import org.springframework.web.bind.annotation.*;
import ru.balmukanov.productmarket.dto.ProductDTO;
import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarket.service.ProductService;

//todo delete after impl inner sync products
@RestController
@RequestMapping("test")
public class TestController {

    private final ProductService productService;

    public TestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/get/by/id/{id}")
    public Product test(@PathVariable Long id) {
        return this.productService.get(id);
    }

    @PostMapping("/product/add")
    public Product add(@RequestBody ProductDTO productDTO) {
        return this.productService.add(productDTO);
    }
}
