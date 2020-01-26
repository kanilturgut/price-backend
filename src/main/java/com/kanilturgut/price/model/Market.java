package com.kanilturgut.price.model;

import javax.persistence.*;

@Entity
@Table(name = "MARKET")
public class Market extends AuditModel {

    @Id
    @GeneratedValue(generator = "market_generator")
    @SequenceGenerator(name = "market_generator", sequenceName = "seq_market")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Market() {
    }

    public Market(String name) {
        this.name = name;
    }
}
