package ru.balmukanov.productmarket.dto;

import ru.balmukanov.productmarketinterface.thrift.ProductType;

public class ProductDto {

    public long id;

    public String externalId;

    public String name;

    public ProductType type;

    public String agreementId;

    public long userId;

    public ProductDto(long id, String externalId, String name, ProductType type, String agreementId, long userId) {
        this.id = id;
        this.externalId = externalId;
        this.name = name;
        this.type = type;
        this.agreementId = agreementId;
        this.userId = userId;
    }
}
