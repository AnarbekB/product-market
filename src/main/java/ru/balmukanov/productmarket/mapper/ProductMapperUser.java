package ru.balmukanov.productmarket.mapper;

import org.springframework.stereotype.Component;
import ru.balmukanov.productmarket.dto.ProductDto;
import ru.balmukanov.productmarket.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapperUser {
    public ProductDto toDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getExternalId(),
                product.getName(),
                product.getType(),
                product.getAgreementId(),
                product.getUserId()
        );
    }

    public List<ProductDto> toDtoList(List<Product> products) {
        List<ProductDto> productDtoList = new ArrayList<>();
        products.forEach(product -> productDtoList.add(this.toDto(product)));

        return productDtoList;
    }
}
