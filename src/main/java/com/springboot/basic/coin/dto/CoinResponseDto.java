package com.springboot.basic.coin.dto;

import com.springboot.basic.coin.entity.Coin;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CoinResponseDto {
    private String symbol;
    private String name;
    private BigDecimal price;
    private String updated;

    private CoinResponseDto coverToResponseDto(Coin coin) {
        CoinResponseDto dto = new CoinResponseDto();
        dto.setSymbol(coin.getSymbol());
        dto.setName(coin.getName());
        dto.setPrice(coin.getPrice());
        dto.setUpdated(coin.getUpdated().toString());
        return dto;
    }
}
