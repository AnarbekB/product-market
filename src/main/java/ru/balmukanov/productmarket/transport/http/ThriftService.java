package ru.balmukanov.productmarket.transport.http;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;
import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarket.mapper.ProductMapper;
import ru.balmukanov.productmarket.service.ProductService;
import ru.balmukanov.productmarketinterface.thrift.ProductDto;
import ru.balmukanov.productmarketinterface.thrift.ProductMarketThriftService;

import java.util.List;

@Service
public class ThriftService implements ProductMarketThriftService.Iface {

    private final ProductService productService;

    private final ProductMapper productMapper;

    public ThriftService(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto get(long l) throws TException {
        Product product = this.productService.get(l);

        return this.productMapper.toDto(product);
    }

    @Override
    public List<ProductDto> userList(long l) {
        List<Product> products = this.productService.userList(l);

        return this.productMapper.toDtoList(products);
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = this.productService.add(productDto);

        return this.productMapper.toDto(product);
    }
}
