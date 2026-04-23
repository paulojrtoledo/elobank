package com.spendly.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "pixKey",
    indexes = {
        @Index(name = "idx_pix_value_key_value", columnList = "key_value"),
        @Index(name = "idx_pix_value_account_id", columnList = "account_id")
    })
public class PixKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @NotNull @Enumerated(EnumType.STRING) private KeyType keyType;
    @NotNull @Column(unique = true, nullable = false)
    @Getter private String keyValue;
    @NotNull @Getter @ManyToOne private Account account;
    @NotNull @Getter private LocalDate createdAt;

    public PixKey(KeyType keyType, String keyValue, Account account) {
        this.keyType = keyType;
        this.keyValue = keyValue;
        this.account = account;
        this.createdAt = LocalDate.now();
    }
}
