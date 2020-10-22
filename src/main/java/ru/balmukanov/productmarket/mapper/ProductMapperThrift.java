package ru.balmukanov.productmarket.mapper;

import org.springframework.stereotype.Component;
import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarketinterface.thrift.ProductDto;

import java.util.ArrayList;
import java.util.List;

@Component()
public class ProductMapperThrift {

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
