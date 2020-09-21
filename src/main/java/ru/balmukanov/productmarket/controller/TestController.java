package ru.balmukanov.productmarket.controller;

import org.springframework.web.bind.annotation.*;
import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarket.service.ProductService;
import ru.balmukanov.productmarketinterface.thrift.ProductDto;
import ru.balmukanov.productmarketinterface.thrift.ProductNotFoundException;

//todo delete after impl inner sync products
@RestController
@RequestMapping("test")
public class TestController {

    private final ProductService productService;

    public TestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/get/by/id/{id}")
    public Product test(@PathVariable Long id) throws ProductNotFoundException {
        return this.productService.get(id);
    }

    @PostMapping("/product/add")
    public Product add(@RequestBody ProductDto productDTO) {
        return this.productService.add(productDTO);
    }
}
