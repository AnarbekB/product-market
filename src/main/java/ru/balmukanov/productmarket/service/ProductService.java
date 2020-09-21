package ru.balmukanov.productmarket.service;

import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarketinterface.thrift.ProductDto;
import ru.balmukanov.productmarketinterface.thrift.ProductNotFoundException;

public interface ProductService {
    Product get(Long id) throws ProductNotFoundException;

    Product add(ProductDto productDTO);
}
