package com.example.demo.domain.model;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transfer {
    private UUID id;
    private Company company;
    private BigDecimal amount;
    private String debitAccount;
    private String creditAccount;
    private LocalDateTime createdAt;
}
