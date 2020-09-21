package ru.balmukanov.productmarket.transport.http;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;
import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarket.service.ProductService;
import ru.balmukanov.productmarketinterface.thrift.InvalidOperationException;
import ru.balmukanov.productmarketinterface.thrift.ProductDto;
import ru.balmukanov.productmarketinterface.thrift.ProductMarketThriftService;
import ru.balmukanov.productmarketinterface.thrift.ProductNotFoundException;

@Service
public class ThriftService implements ProductMarketThriftService.Iface {

    private final ProductService productService;

    public ThriftService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductDto get(long l) throws InvalidOperationException, ProductNotFoundException, TException {
        Product product = this.productService.get(l);

        return new ProductDto(
                product.getId(),
                product.getExternalId(),
                product.getName(),
                product.getType(),
                product.getAgreementId(),
                product.getUserId()
        );
    }

    @Override
    public void save(ProductDto productDto) throws InvalidOperationException, TException {
        this.productService.add(productDto);
    }

    @Override
    public boolean ping() throws InvalidOperationException, TException {
        return true;
    }
}
