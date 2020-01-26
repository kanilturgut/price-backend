package com.kanilturgut.price.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
public class Transaction extends AuditModel {

    @Id
    @GeneratedValue(generator = "transaction_generator")
    @SequenceGenerator(name = "transaction_generator", sequenceName = "seq_transaction")
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MARKET_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Market market;

    @Column(name = "ORIGINAL_PRICE", nullable = false)
    private String originalPrice;

    @Column(name = "DISCOUNTED_PRICE")
    private String discountedPrice;

    public Transaction() {
    }

    public Transaction(Product product, Market market, Date date, double originalPrice, double discountedPrice) {
        this.market = market;
        this.product = product;
        this.createdAt = date;
        this.originalPrice = String.valueOf(originalPrice);
        if (0 != discountedPrice) {
            this.discountedPrice = String.valueOf(discountedPrice);
        }
    }
}
