package com.springboot.basic.coin.service;

import com.springboot.basic.coin.dto.CoinRequestDto;
import com.springboot.basic.coin.dto.CoinResponseDto;

import java.math.BigDecimal;
import java.util.List;

public interface CoinService {
    // 코인 등록
    CoinResponseDto addCoin(CoinRequestDto coinRequestDto);

    // 코인 삭제
    CoinResponseDto deleteCoin(CoinResponseDto coinResponseDto);

    // 코인 삭제
    void deleteCoin(String symbol);

    // 전체 코인 목록 조회
    List<CoinResponseDto> getAllcoins();

    // 특정 코인 조회
    CoinResponseDto getCoinBySymbol(String symbol);

    // 코인 가격 갱신
    void updateCoinPrices(String symbol, BigDecimal newprice);

}
