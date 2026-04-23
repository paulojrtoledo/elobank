package com.spendly.api.exception.response;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
public class ErrorResponse {
    private final String message;
    private final  int status;
    private final LocalDateTime timestamp;
    private final Map<String, String> fields;

    public ErrorResponse(String message, int status, LocalDateTime timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.fields = null;
    }

    public ErrorResponse(String message, int status, LocalDateTime timestamp, Map<String, String> fields) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.fields = fields;
    }
}
