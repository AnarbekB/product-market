package ru.balmukanov.productmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.balmukanov.productmarket.entity.Product;
import ru.balmukanov.productmarket.entity.Requisite;

public interface RequisiteRepository extends JpaRepository<Requisite, Long> {
    Requisite getRequisiteByProduct(Product product);
}
