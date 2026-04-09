package com.elobank.domain.repository;

import com.elobank.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public boolean existsByCpf(String cpf);

    Optional<Customer> findByCpf(String cpf);
}
