package com.alan.ledgerapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 交易描述
     */
    private String description;

    /**
     * 金额
     */
    @Column(nullable = false)
    private BigDecimal amount;

    /**
     * 类型（如：INCOME / EXPENSE）
     */
    @Column(nullable = false, length = 20)
    private String type;

    /**
     * 类别（如：餐饮、交通等）
     */
    private String category;

    /**
     * 日期
     */
    private LocalDate date;
}

