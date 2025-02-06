package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.example.domain.model.Transfer;

@Entity
@Table(name = "transfers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity company;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String debitAccount;

    @Column(nullable = false)
    private String creditAccount;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Conversión a dominio
    public Transfer toDomain() {
        return new Transfer(id, company.toDomain(), amount, debitAccount, creditAccount, createdAt);
    }

    // Conversión desde dominio
    public static TransferEntity fromDomain(Transfer transfer) {
        return new TransferEntity(
                transfer.getId(),
                CompanyEntity.fromDomain(transfer.getCompany()),
                transfer.getAmount(),
                transfer.getDebitAccount(),
                transfer.getCreditAccount(),
                transfer.getCreatedAt()
        );
    }
}

