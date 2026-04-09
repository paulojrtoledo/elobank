package com.elobank.api.controller;

import com.elobank.api.dto.request.LoginRequestDTO;
import com.elobank.api.dto.response.LoginResponseDTO;
import com.elobank.domain.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO data) {
        return authService.login(data);
    }
}