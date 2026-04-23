package com.spendly.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "payment_key",
    indexes = {
        @Index(name = "idx_payment_key_value", columnList = "key_value"),
        @Index(name = "idx_payment_key_wallet_id", columnList = "wallet_id")
    })
public class PaymentKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @NotNull @Enumerated(EnumType.STRING) private PaymentKeyType keyType;
    @NotNull @Column(unique = true, nullable = false)
    @Getter private String keyValue;
    @NotNull @Getter @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
    @NotNull @Getter private LocalDate createdAt;

    public PaymentKey(PaymentKeyType keyType, String keyValue, Wallet wallet) {
        this.keyType = keyType;
        this.keyValue = keyValue;
        this.wallet = wallet;
        this.createdAt = LocalDate.now();
    }
}
