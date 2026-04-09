package com.elobank.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record LoginRequestDTO(
        @NotBlank
        @Size(min=11, max=11)
        String cpf,
        @NotBlank
        @Pattern(regexp = "^\\d{6}$")
        @Size(min=6, max=6)
        String password
) {
}
