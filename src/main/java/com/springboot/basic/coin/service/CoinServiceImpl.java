package com.springboot.basic.coin.service;

import com.springboot.basic.coin.dto.CoinRequestDto;
import com.springboot.basic.coin.dto.CoinResponseDto;
import com.springboot.basic.coin.entity.Coin;
import com.springboot.basic.coin.repository.CoinRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CoinServiceImpl implements CoinService{
    private final CoinRepository coinRepository;

    public CoinServiceImpl(CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    // 코인 추가
    @Override
    public CoinResponseDto addCoin(CoinRequestDto coinRequestDto) {
        if (coinRepository.findBySymbol(coinRequestDto.getSymbol()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 코인입니다.");
        }
        Coin coin = new Coin();
        coin.setSymbol(coinRequestDto.getSymbol());
        coin.setName(coinRequestDto.getName());
        coin.setPrice(BigDecimal.ZERO); // 기본값 = 0
        coin.setUpdated(LocalDateTime.now());

        Coin savedCoin = coinRepository.save(coin);
        return convertToResponseDto(savedCoin);

    }
    // 응답 DTO 생성
    private CoinResponseDto convertToResponseDto(Coin coin) {
        CoinResponseDto dto = new CoinResponseDto();
        dto.setSymbol(coin.getSymbol());
        dto.setName(coin.getName());
        dto.setPrice(coin.getPrice());
        dto.setUpdated(coin.getUpdated().toString());
        return dto;
    }

    @Override
    public CoinResponseDto deleteCoin(CoinResponseDto coinResponseDto) {
        return null;
    }

    @Override
    public List<CoinResponseDto> getAllcoins() {
        return List.of();
    }

    @Override
    public CoinResponseDto getCoinBySymbol(String symbol) {
        return null;
    }

    @Override
    public void updateCoinPrices(String symbol, BigDecimal newprice) {

    }
}
