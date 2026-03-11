package com.elobank.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "loginAudit")
public class LoginAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Getter private Customer customer;
    @NotNull @Getter private LocalDateTime timestamp;
    @NotNull private String ip;
    private boolean success;
    private String failureReason;

    public LoginAudit(Customer customer, String ip, boolean success, String failureReason) {
        this.customer = customer;
        this.ip = ip;
        this.success = success;
        this.failureReason = failureReason;
        this.timestamp = LocalDateTime.now();
    }
}
