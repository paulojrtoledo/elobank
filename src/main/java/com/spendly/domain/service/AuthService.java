package com.spendly.domain.service;

import com.spendly.api.dto.request.LoginRequestDTO;
import com.spendly.api.dto.response.LoginResponseDTO;
import com.spendly.domain.entity.Customer;
import com.spendly.domain.exception.InvalidCredentialsException;
import com.spendly.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginResponseDTO login(LoginRequestDTO data) {
        Customer customer = customerRepository.findByCpf(data.cpf())
                .orElseThrow(() -> new InvalidCredentialsException("CPF ou senha inválidos"));

        boolean passwordMatches = passwordEncoder.matches(data.password(), customer.getPasswordHash());

        if (!passwordMatches) {
            throw new InvalidCredentialsException("CPF ou senha inválidos");
        }

        String token = jwtService.generateToken(customer);

        return new LoginResponseDTO(token, "Bearer");
    }
}