package ru.balmukanov.productmarket.dto;

import lombok.Data;
import ru.balmukanov.productmarket.constant.ProductType;

@Data
public class AddProductDto {
    public String externalId;
    public String name;
    public ProductType type;
    public String agreementId;
    public long userId;
    public double amount;
    public String currency;
    public boolean active;
}