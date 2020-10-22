package ru.balmukanov.productmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.balmukanov.productmarket.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByUserId(Long userId);
}
