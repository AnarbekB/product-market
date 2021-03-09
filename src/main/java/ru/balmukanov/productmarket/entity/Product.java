package ru.balmukanov.productmarket.entity;

import lombok.*;
import ru.balmukanov.productmarket.constant.ProductType;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
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
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @NotNull
    @Column(nullable = false)
    private String agreementId;

    @NotNull
    @Column(nullable = false)
    private Long userId;

    @NotNull
    @Column(nullable = false)
    private double amount;

    @OneToOne(mappedBy = "product")
    private Requisite requisite;

    @NotNull
    @Column(nullable = false)
    private String currency;

    @NotNull
    @Column(nullable = false)
    private boolean active;

    @NotNull
    @Column(nullable = false)
    private boolean hide;

    @Column()
    private String image;

    public Product() {
        this.hide = false;
    }
}
