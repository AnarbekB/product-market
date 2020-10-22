package ru.balmukanov.productmarket.controller;

import org.springframework.web.bind.annotation.*;
import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarket.mapper.ProductMapper;
import ru.balmukanov.productmarket.service.ProductService;
import ru.balmukanov.productmarketinterface.thrift.ProductDto;

import java.util.List;

@RestController
@RequestMapping("product")
public class UserProductController {

    private final ProductService productService;

    private final ProductMapper productMapper;

    UserProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("user/{userId}/list")
    public List<ProductDto> list(@PathVariable Long userId) {
        List<Product> products = this.productService.userList(userId);

        return this.productMapper.toDtoList(products);
    }

    @GetMapping("requisites")
    public String requisites() {
        return "";
    }

    @PostMapping("update")
    public String update() {
        return "";
    }
}
