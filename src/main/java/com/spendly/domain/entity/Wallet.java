package com.spendly.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "wallet",
    indexes = {
        @Index(name = "idx_wallet_wallet_number", columnList = "wallet_number")
    })
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Getter private int branch;
    @NotNull @Getter private Long walletNumber;
    @NotNull @PositiveOrZero @Getter private double balance;
    @Getter @Setter
    @NotNull @Enumerated(EnumType.STRING) private WalletType walletType;
    @NotNull private LocalDate openingDate;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull private Customer customer;

    public Wallet(int branch, Long walletNumber, Customer customer) {
        this.branch = branch;
        this.walletNumber = walletNumber;
        this.customer = customer;
        this.openingDate = LocalDate.now();
    }
}