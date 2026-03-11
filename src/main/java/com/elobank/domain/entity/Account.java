package com.elobank.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "account",
    indexes = {
        @Index(name = "idx_account_account_number", columnList = "account_number")
    })
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Getter private int branch;
    @NotNull @Getter private Long accountNumber;
    @NotNull @PositiveOrZero @Getter private double balance;
    @Getter @Setter
    @NotNull @Enumerated(EnumType.STRING) private AccountType accountType;
    @NotNull private LocalDate openingDate;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull private Customer customer;

    public Account(int branch, Long accountNumber, Customer customer) {
        this.branch = branch;
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.openingDate = LocalDate.now();
    }
}
