package ru.balmukanov.productmarket.entity;

import lombok.*;
import ru.balmukanov.productmarketinterface.thrift.ProductType;

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

    private String externalId;

    private String name;

    private ProductType type;

    private String agreementId;

    private int userId;

}
