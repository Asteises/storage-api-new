package ru.asteises.storageapi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.asteises.storageapi.exception.ItemNotFound;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({ItemNotFound.class})
    public ResponseEntity<String> userNotFoundHandler(final RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
