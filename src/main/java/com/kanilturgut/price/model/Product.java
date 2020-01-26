package com.kanilturgut.price.model;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product extends AuditModel {

    @Id
    @GeneratedValue(generator = "product_generator")
    @SequenceGenerator(name = "product_generator", sequenceName = "seq_product")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }
}
