package com.spendly.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "loginAudit")
public class LoginAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Getter @ManyToOne private Customer customer;
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
