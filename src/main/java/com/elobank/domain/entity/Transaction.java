package com.elobank.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction",
    indexes = {
        @Index(name = "idx_transaction_source_account", columnList = "source_account_id"),
        @Index(name = "idx_transaction_destination_account", columnList = "destination_account_id")
    })
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Positive @Getter private double amount;
    @NotNull @Getter @Enumerated(EnumType.STRING) private TransactionType transactionType;
    @NotNull @Getter private LocalDateTime timestamp;
    @NotNull @Getter @ManyToOne private Account sourceAccount;
    @NotNull @Getter @ManyToOne private Account destinationAccount;
    @Getter @Enumerated(EnumType.STRING) private TransactionStatus transactionStatus = TransactionStatus.PENDING;

    public Transaction(double amount, Account sourceAccount, Account destinationAccount, TransactionType transactionType) {
        this.amount = amount;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.transactionType = transactionType;
        this.timestamp = LocalDateTime.now();
    }
}
