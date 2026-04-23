package com.spendly.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "transaction",
    indexes = {
        @Index(name = "idx_transaction_source_wallet", columnList = "source_wallet_id"),
        @Index(name = "idx_transaction_destination_wallet", columnList = "destination_wallet_id")
    })
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Positive @Getter private double amount;
    @NotNull @Getter @Enumerated(EnumType.STRING) private TransactionType transactionType;
    @NotNull @Getter private LocalDateTime timestamp;
    @NotNull @Getter @ManyToOne
    @JoinColumn(name = "source_wallet_id")
    private Wallet sourceWallet;
    @NotNull @Getter @ManyToOne
    @JoinColumn(name = "destination_wallet_id")
    private Wallet destinationWallet;
    @Getter @Enumerated(EnumType.STRING) private TransactionStatus transactionStatus = TransactionStatus.PENDING;

    public Transaction(double amount, Wallet sourceWallet, Wallet destinationWallet, TransactionType transactionType) {
        this.amount = amount;
        this.sourceWallet = sourceWallet;
        this.destinationWallet = destinationWallet;
        this.transactionType = transactionType;
        this.timestamp = LocalDateTime.now();
    }
}
