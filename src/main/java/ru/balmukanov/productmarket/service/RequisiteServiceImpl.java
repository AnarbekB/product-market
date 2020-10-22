package ru.balmukanov.productmarket.service;

import org.springframework.stereotype.Service;
import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarket.entity.Requisite;
import ru.balmukanov.productmarket.exception.RequisiteNotFoundException;
import ru.balmukanov.productmarketinterface.thrift.ProductNotFoundException;

@Service
public class RequisiteServiceImpl implements RequisiteService {

    private final ProductService productService;

    RequisiteServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Requisite productRequisite(Long productId) throws RequisiteNotFoundException {
        try {
            Product product = this.productService.get(productId);
            if (product.getRequisite() == null) {
                throw new RequisiteNotFoundException();
            }
            return product.getRequisite();
        } catch (ProductNotFoundException exception) {
            throw new RequisiteNotFoundException();
        }
    }
}
