package com.kanilturgut.price.service;

import com.kanilturgut.price.controller.TransactionRequest;
import com.kanilturgut.price.model.Market;
import com.kanilturgut.price.model.Product;
import com.kanilturgut.price.model.Transaction;
import com.kanilturgut.price.repository.MarketRepository;
import com.kanilturgut.price.repository.ProductRepository;
import com.kanilturgut.price.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final MarketRepository marketRepository;
    private final ProductRepository productRepository;

    public TransactionService(TransactionRepository transactionRepository, MarketRepository marketRepository, ProductRepository productRepository) {
        this.transactionRepository = transactionRepository;
        this.marketRepository = marketRepository;
        this.productRepository = productRepository;
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public void createTransaction(TransactionRequest transactionRequest) {

        List<TransactionRequest.MarketProduct> transactions = transactionRequest.getTransactions();
        transactions.forEach(transaction -> {

            String marketName = transaction.getMarket();
            Market market = marketRepository.findByNameIgnoreCase(marketName);
            if (null == market) {
                market = marketRepository.save(new Market(marketName));
            }

            String productName = transaction.getProduct();
            Product product = productRepository.findByNameIgnoreCase(productName);
            if (null == product) {
                product = productRepository.save(new Product(productName));
            }

            double discountedPrice = transaction.getDiscountedPrice();
            double originalPrice = transaction.getOriginalPrice();
            long date = transaction.getDate();

            Transaction transactionEntity = new Transaction(product, market, new Date(date), originalPrice, discountedPrice);
            transactionRepository.save(transactionEntity);
        });
    }
}
