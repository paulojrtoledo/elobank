package com.elobank.domain.entity;

public enum CustomerStatus {
    ACTIVE("Ativo"),
    BLOCKED("Bloqueado");

    private String description;

    CustomerStatus(String description) {
        this.description = description;
    }
}
