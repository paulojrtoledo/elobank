package com.elobank.config;

import com.elobank.api.exception.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException
    ) throws IOException {
        ErrorResponse error = new ErrorResponse(
                "Acesso negado",
                HttpServletResponse.SC_FORBIDDEN,
                LocalDateTime.now()
        );

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
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

