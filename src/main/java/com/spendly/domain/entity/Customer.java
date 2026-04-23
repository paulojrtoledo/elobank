package com.spendly.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "customer",
    indexes = {
        @Index(name = "idx_customer_cpf", columnList = "cpf"),
        @Index(name = "idx_customer_email", columnList = "email")
    })
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Setter @Column(nullable = false) private String name;
    @NotNull
    @Size(min = 11, max = 11)
    @Column(unique = true, nullable = false) private String cpf;
    @NotNull private String passwordHash;
    @Email @NotNull @Setter private String email;
    @Setter private String phone;
    private LocalDate registrationDate;
    @Enumerated(EnumType.STRING) private CustomerStatus status;
    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;


    public Customer(String name, String cpf, String passwordHash, String email) {
        this.name = name;
        this.cpf = cpf;
        this.passwordHash = passwordHash;
        this.email = email;
        this.registrationDate = LocalDate.now();
        this.status = CustomerStatus.ACTIVE;
    }

    public void block() {
        this.status = CustomerStatus.BLOCKED;
    }

    public void activate() {
        this.status = CustomerStatus.ACTIVE;
    }
}