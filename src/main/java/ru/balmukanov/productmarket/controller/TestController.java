package ru.balmukanov.productmarket.controller;

import org.springframework.web.bind.annotation.*;
import ru.balmukanov.productmarket.dto.ProductDTO;
import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarket.service.ProductService;

@RestController
@RequestMapping("test")
public class TestController {

    private final ProductService productService;

    public TestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/get/by/id/{id}")
    public String test(@PathVariable Long id) {
        Product product = this.productService.get(id);
        return product.getName();
    }

    @PostMapping("/product/add")
    public String main(@RequestBody ProductDTO productDTO) {
        this.productService.add(productDTO);
        return "ok";
    }
}
