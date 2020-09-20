package ru.balmukanov.productmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.balmukanov.productmarket.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
