package com.example.SimpleBank.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequest {

    private Integer id;

    private String customerId;
    private BigDecimal balance;
    private LocalDateTime creationDate;
}
