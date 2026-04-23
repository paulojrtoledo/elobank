package com.spendly.domain.repository;

import com.spendly.domain.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}