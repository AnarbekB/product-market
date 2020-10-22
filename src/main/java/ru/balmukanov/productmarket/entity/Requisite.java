package ru.balmukanov.productmarket.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "requisites")
public class Requisite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String BIC;

    @NotNull
    @Column(nullable = false)
    //Банк получатель
    private String bankName;

    @NotNull
    @Column(nullable = false)
    private String INN;

    @NotNull
    @Column(nullable = false)
    private String KPP;

    @NotNull
    @Column(nullable = false)
    //Счет получателя
    private String recipientAccount;

    @NotNull
    @Column(nullable = false)
    private String recipient;

    @NotNull
    @Column(nullable = false)
    //Корреспондентский счет
    private String correspondentAccount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
}
