package ru.balmukanov.productmarket.service;

import ru.balmukanov.productmarket.entity.Requisite;
import ru.balmukanov.productmarket.exception.RequisiteNotFoundException;

public interface RequisiteService {
    Requisite productRequisite(Long productId) throws RequisiteNotFoundException;
}
