package ru.balmukanov.productmarket.mapper;

import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarketinterface.thrift.ProductDto;

import java.util.List;

public interface ProductMapper {
    ProductDto toDto(Product product);

    List<ProductDto> toDtoList(List<Product> products);
}
