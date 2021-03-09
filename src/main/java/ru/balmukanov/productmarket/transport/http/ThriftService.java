package ru.balmukanov.productmarket.transport.http;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;
import ru.balmukanov.productmarket.constant.ProductType;
import ru.balmukanov.productmarket.dto.AddProductDto;
import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarket.mapper.ProductMapperThrift;
import ru.balmukanov.productmarket.service.ProductService;
import ru.balmukanov.productmarketinterface.thrift.CreateProductDto;
import ru.balmukanov.productmarketinterface.thrift.ProductDto;
import ru.balmukanov.productmarketinterface.thrift.ProductMarketThriftService;

import java.util.List;

@Service
public class ThriftService implements ProductMarketThriftService.Iface {

    private final ProductService productService;

    private final ProductMapperThrift productMapper;

    public ThriftService(ProductService productService, ProductMapperThrift productMapper) {
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
    public ProductDto save(CreateProductDto productDto) {
        var addProductDto = new AddProductDto();
        addProductDto.setName(productDto.getName());
        addProductDto.setUserId(productDto.getUserId());
        addProductDto.setExternalId(productDto.getExternalId());
        addProductDto.setType(ProductType.valueOf(productDto.getType().toString().toUpperCase()));
        addProductDto.setActive(productDto.isActive());
        addProductDto.setAmount(productDto.getAmount());
        addProductDto.setCurrency(productDto.getCurrency());
        addProductDto.setAgreementId(productDto.getAgreementId());

        Product product = this.productService.add(addProductDto);

        return this.productMapper.toDto(product);
    }
}
