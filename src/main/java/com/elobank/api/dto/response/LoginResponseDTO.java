package com.elobank.api.dto.response;

public record LoginResponseDTO(
        String token,
        String type
) {
}