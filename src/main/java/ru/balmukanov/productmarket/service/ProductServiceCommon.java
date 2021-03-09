package ru.balmukanov.productmarket.service;

import org.springframework.stereotype.Service;
import ru.balmukanov.productmarket.dto.AddProductDto;
import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarket.repository.ProductRepository;
import ru.balmukanov.productmarketinterface.thrift.ProductNotFoundException;

import java.util.List;

@Service
public class ProductServiceCommon implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceCommon(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product get(Long id) throws ProductNotFoundException {
        return this.productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Product add(AddProductDto productDTO) {
        Product product = new Product();
        product.setName(productDTO.name);
        product.setAgreementId(productDTO.agreementId);
        product.setExternalId(productDTO.externalId);
        product.setType(productDTO.type);
        product.setUserId(productDTO.userId);

        this.productRepository.saveAndFlush(product);

        return product;
    }

    @Override
    public List<Product> userList(Long userId) {
        return this.productRepository.findProductsByUserId(userId);
    }
}
