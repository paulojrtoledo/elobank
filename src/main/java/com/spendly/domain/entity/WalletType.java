package com.spendly.domain.entity;

public enum WalletType {
    CHECKING("Conta Corrente"),
    SAVINGS("Poupança");

    private String description;

    WalletType(String description) {
        this.description = description;
    }
}