package ru.balmukanov.productmarket.service;

import ru.balmukanov.productmarket.dto.AddProductDto;
import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarketinterface.thrift.ProductDto;
import ru.balmukanov.productmarketinterface.thrift.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    Product get(Long id) throws ProductNotFoundException;

    List<Product> userList(Long userId);

    Product add(AddProductDto productDTO);
}
