package com.elobank.domain.service;

import com.elobank.api.dto.request.LoginRequestDTO;
import com.elobank.api.dto.response.LoginResponseDTO;
import com.elobank.domain.entity.Customer;
import com.elobank.domain.exception.InvalidCredentialsException;
import com.elobank.domain.repository.CustomerRepository;
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