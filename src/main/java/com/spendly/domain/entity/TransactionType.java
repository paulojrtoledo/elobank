package com.spendly.domain.entity;

public enum TransactionType {
    INCOME("Entrada financeira"),
    EXPENSE("Saída financeira"),
    TRANSFER("Transferência entre carteiras");

    private String description;

    TransactionType(String description) {
        this.description = description;
    }
}
