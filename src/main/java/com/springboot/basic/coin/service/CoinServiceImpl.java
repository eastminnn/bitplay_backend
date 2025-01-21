package com.springboot.basic.coin.service;

import com.springboot.basic.coin.dto.CoinRequestDto;
import com.springboot.basic.coin.dto.CoinResponseDto;
import com.springboot.basic.coin.entity.Coin;
import com.springboot.basic.coin.repository.CoinRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

        // 엔티티 생성
        Coin coin = new Coin();
        coin.setSymbol(coinRequestDto.getSymbol());
        coin.setName(coinRequestDto.getName());
        coin.setPrice(BigDecimal.ZERO); // 기본값 = 0
        coin.setUpdated(LocalDateTime.now());

        // 코인 저장
        Coin savedCoin = coinRepository.save(coin);
        return convertToResponseDto(savedCoin);

    }

    @Override
    public CoinResponseDto deleteCoin(CoinResponseDto coinResponseDto) {
        return null;
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

    // 코인 삭제
    @Override
    public void deleteCoin(String symbol) {
        Coin coin = coinRepository.findBySymbol(symbol)
                .orElseThrow(() -> new IllegalArgumentException("코인을 찾을 수 없습니다 : " + symbol));
        coinRepository.delete(coin);
    }

    // 전체 코인 조회
    @Override
    public List<CoinResponseDto> getAllcoins() {
        return coinRepository.findAll().stream()
                .map(this::convertToResponseDto) // 엔티티를 DTO로 변환
                .collect(Collectors.toList());
    }

    // 특정 코인 조회
    @Override
    public CoinResponseDto getCoinBySymbol(String symbol) {
        Coin coin = coinRepository.findBySymbol(symbol)
                .orElseThrow(() -> new IllegalArgumentException("코인을 찾을 수 없습니다 : " + symbol);
        return convertToResponseDto(coin); // 엔티티를 DTO로 변환
    }

    @Override
    public void updateCoinPrices(String symbol, BigDecimal newprice) {

    }
}
