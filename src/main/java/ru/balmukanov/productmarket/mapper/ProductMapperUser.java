package ru.balmukanov.productmarket.mapper;

import org.springframework.stereotype.Component;
import ru.balmukanov.productmarket.dto.ProductDto;
import ru.balmukanov.productmarket.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapperUser {
    public ProductDto toDto(Product product) {
        var dto = new ProductDto();
        dto.setId(product.getId());
        dto.setActive(product.isActive());
        dto.setAgreementId(product.getAgreementId());
        dto.setAmount(product.getAmount());
        dto.setCurrency(product.getCurrency());
        dto.setUserId(product.getUserId());
        dto.setType(product.getType());
        dto.setExternalId(product.getExternalId());
        dto.setHide(product.isHide());
        dto.setImage(product.getImage());

        return dto;
    }

    public List<ProductDto> toDtoList(List<Product> products) {
        List<ProductDto> productDtoList = new ArrayList<>();
        products.forEach(product -> productDtoList.add(this.toDto(product)));

        return productDtoList;
    }
}
