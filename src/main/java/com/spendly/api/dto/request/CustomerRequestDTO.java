package com.spendly.api.dto.request;
import jakarta.validation.constraints.*;

public record CustomerRequestDTO(
        @NotBlank
        String name,
        @NotBlank
        @Size(min = 11, max = 11)
        String cpf,
        @NotBlank
        @Pattern(regexp = "^\\d{6}$")
        @Size(min = 6, max = 6)
        String password,
        @NotBlank
        @Email
        String email) {
}
