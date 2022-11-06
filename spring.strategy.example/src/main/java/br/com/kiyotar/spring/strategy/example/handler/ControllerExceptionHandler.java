package br.com.kiyotar.spring.strategy.example.handler;

import br.com.kiyotar.spring.strategy.example.dto.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMessage> badRequestException(BadRequestException ex, WebRequest request) {
        ErrorMessage message = buildErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> globalException(Exception ex, WebRequest request) {
        ErrorMessage message = buildErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static ErrorMessage buildErrorMessage(HttpStatus status, String message) {
        return ErrorMessage.builder()
                .status_code(status.value())
                .status_name(status.name())
                .message(message)
                .datetime(LocalDateTime.now().toString()).build();
    }
}
