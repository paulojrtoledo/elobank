package com.spendly.api.dto.response;

public record LoginResponseDTO(
        String token,
        String type
) {
}