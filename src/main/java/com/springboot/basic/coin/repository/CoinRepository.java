package com.springboot.basic.coin.repository;

import com.springboot.basic.coin.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoinRepository extends JpaRepository<Coin, Long> {
    Optional<Coin> findBySymbol(String symbol); // 심볼로 검색
}
