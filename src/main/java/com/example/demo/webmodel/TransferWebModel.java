package com.example.demo.webmodel;

import java.math.BigDecimal;

import com.example.demo.domain.model.Transfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferWebModel {
    private String id;
    private String debitAccount;
    private String creditAccount;
    private BigDecimal amount;

    public static TransferWebModel fromDomainModel(Transfer transfer) {
        TransferWebModel model = new TransferWebModel();
        model.id = transfer.getId().toString();
        model.debitAccount = transfer.getDebitAccount();
        model.creditAccount = transfer.getCreditAccount();
        model.amount = transfer.getAmount();
        return model;
    }
}

