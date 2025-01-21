package com.springboot.basic.coin.dto;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class CoinResponseDto {
    private String symbol;
    private String name;
    private BigDecimal price;
    private String updated;
}
