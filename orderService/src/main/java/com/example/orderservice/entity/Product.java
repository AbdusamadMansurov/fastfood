package com.example.orderservice.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne()
//    @JoinColumn(nullable = false)
    private Attachment photo;

    @Column(nullable = false)
    private String nameUz, nameRu;

    @Column(nullable = false, scale = 2)
    private Double price;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @Column(nullable = false)
    @Builder.Default
    private boolean active=true;
}
