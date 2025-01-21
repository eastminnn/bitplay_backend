package com.springboot.basic.coin.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CoinRequestDto {
    @NotBlank(message = "코인 심볼은 필수입니다.")
    private String symbol;

    @NotBlank(message = "코인 이름은 필수입니다.")
    private String name;
}
