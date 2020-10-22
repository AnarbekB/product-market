package ru.balmukanov.productmarket.entity;

import lombok.*;
import ru.balmukanov.productmarketinterface.thrift.ProductType;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String externalId;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private ProductType type;

    @NotNull
    @Column(nullable = false)
    private String agreementId;

    @NotNull
    @Column(nullable = false)
    private Long userId;
}
