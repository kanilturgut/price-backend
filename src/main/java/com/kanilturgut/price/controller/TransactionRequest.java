package com.kanilturgut.price.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TransactionRequest {

    @JsonProperty("transactions")
    private List<MarketProduct> transactions;

    public List<MarketProduct> getTransactions() {
        return transactions;
    }

    public static class MarketProduct {

        @JsonProperty("product")
        private String product;

        @JsonProperty("market")
        private String market;

        @JsonProperty("originalPrice")
        private double originalPrice;

        @JsonProperty("discountedPrice")
        private double discountedPrice;

        @JsonProperty("date")
        private long date;

        public String getProduct() {
            return product;
        }

        public String getMarket() {
            return market;
        }

        public double getOriginalPrice() {
            return originalPrice;
        }

        public double getDiscountedPrice() {
            return discountedPrice;
        }

        public long getDate() {
            return date;
        }

    }
}
