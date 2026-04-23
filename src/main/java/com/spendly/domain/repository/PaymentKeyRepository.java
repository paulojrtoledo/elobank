package com.spendly.domain.repository;

import com.spendly.domain.entity.PaymentKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentKeyRepository extends JpaRepository<PaymentKey, Long> {
}
