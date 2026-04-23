package com.spendly.domain.entity;

public enum TransactionType {
    PIX("Transferência por Pix"),
    TED("Transferência Eletrônica Disponível"),
    DEBIT("Transferência por Débito");

    private String description;

    TransactionType(String description) {
        this.description = description;
    }
}
