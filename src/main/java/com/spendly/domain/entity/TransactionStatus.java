package com.spendly.domain.entity;

public enum TransactionStatus {
    PENDING("Transação pendente"),
    COMPLETED("Transação efetuada com sucesso"),
    FAILED("Transação incompleta");

    private String description;

    TransactionStatus(String description){
        this.description = description;
    }
}
