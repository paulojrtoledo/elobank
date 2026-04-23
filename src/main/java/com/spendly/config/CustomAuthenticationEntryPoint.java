package com.spendly.config;

import com.spendly.api.exception.response.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException, ServletException {
        String message = authException.getMessage() != null
                ? authException.getMessage()
                : "Nao autenticado";

        ErrorResponse error = new ErrorResponse(
                message,
                HttpServletResponse.SC_UNAUTHORIZED,
                LocalDateTime.now()
        );

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(toJson(error));
    }

    private String toJson(ErrorResponse error) {
        String safeMessage = error.getMessage().replace("\"", "\\\"");
        String timestamp = error.getTimestamp().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return "{\"message\":\"" + safeMessage + "\",\"status\":" + error.getStatus()
                + ",\"timestamp\":\"" + timestamp + "\"}";
    }
}

