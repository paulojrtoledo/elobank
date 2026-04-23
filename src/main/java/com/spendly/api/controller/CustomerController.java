package com.spendly.api.controller;

import com.spendly.api.dto.request.CustomerRequestDTO;
import com.spendly.api.dto.response.CustomerResponseDTO;
import com.spendly.domain.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public CustomerResponseDTO registerCustomer(@Valid @RequestBody CustomerRequestDTO customerRequestDTO) {
        return customerService.registerNewCustomer(customerRequestDTO);
    }

    @GetMapping("/customers/me")
    public CustomerResponseDTO getCurrentUser(Authentication authentication) {
        String cpf = authentication.getName();
        return customerService.getCurrentCustomer(cpf);
    }
}
