package com.springboot.basic.coin.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "coin")
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, unique = true, length = 15)
    private String symbol; // (예 : BTC)

    @Column(nullable = true, length = 50)
    private String name;

    @Column(nullable = true)
    private BigDecimal price;

    @UpdateTimestamp
    private LocalDateTime updated;
}
