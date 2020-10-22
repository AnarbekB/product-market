package ru.balmukanov.productmarket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.balmukanov.productmarket.dto.ProductDto;
import ru.balmukanov.productmarket.dto.RequisiteDto;
import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarket.entity.Requisite;
import ru.balmukanov.productmarket.exception.RequisiteNotFoundException;
import ru.balmukanov.productmarket.mapper.ProductMapperUser;
import ru.balmukanov.productmarket.mapper.RequisiteMapper;
import ru.balmukanov.productmarket.service.ProductService;
import ru.balmukanov.productmarket.service.RequisiteService;

import java.util.List;

@RestController
@RequestMapping("product")
public class UserProductController {

    private final ProductService productService;

    private final ProductMapperUser productMapper;

    private final RequisiteService requisiteService;

    private final RequisiteMapper requisiteMapper;

    UserProductController(ProductService productService, ProductMapperUser productMapper,
                          RequisiteService requisiteService, RequisiteMapper requisiteMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
        this.requisiteService = requisiteService;
        this.requisiteMapper = requisiteMapper;
    }

    @GetMapping("user/{userId}/list")
    public List<ProductDto> list(@PathVariable Long userId) {
        List<Product> products = this.productService.userList(userId);

        return this.productMapper.toDtoList(products);
    }

    @GetMapping("requisites/{productId}")
    public RequisiteDto requisites(@PathVariable Long productId) {
        try {
            Requisite requisite = this.requisiteService.productRequisite(productId);
            return this.requisiteMapper.toDto(requisite);
        } catch (RequisiteNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Requisite not found");
        }
    }

    @PostMapping("update")
    public String update() {
        return "";
    }
}
