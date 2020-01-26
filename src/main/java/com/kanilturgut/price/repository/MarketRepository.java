package com.kanilturgut.price.repository;

import com.kanilturgut.price.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {

    Market findByNameIgnoreCase(String name);
}
