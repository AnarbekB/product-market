package ru.balmukanov.productmarket.service;

import ru.balmukanov.productmarket.dto.ProductDTO;
import ru.balmukanov.productmarket.entity.Product;

public interface ProductService {
    Product get(Long id);

    Product add(ProductDTO productDTO);
}
