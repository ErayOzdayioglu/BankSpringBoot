package com.example.SimpleBank.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Account {

    @Id
    private Integer id;

    private String customerId;
    private BigDecimal balance;
    private LocalDateTime creationDate;



}
