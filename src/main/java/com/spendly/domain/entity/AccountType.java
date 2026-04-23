package com.spendly.domain.entity;

public enum AccountType {
    CHECKING("Conta Corrente"),
    SAVINGS("Poupança");

    private String description;

    AccountType(String description) {
        this.description = description;
    }
}
