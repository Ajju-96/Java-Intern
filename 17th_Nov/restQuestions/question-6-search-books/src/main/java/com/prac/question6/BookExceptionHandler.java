package com.prac.question6;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException exception) {
        // TODO: return the exception message with HTTP 400
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleNotFound(BookNotFoundException exception) {
        // TODO: return the exception message with HTTP 404

        @ExceptionHandler(IllegalArgumentExeption.class)
        public ResponseEntity<String> handleBadRequest(
                IllegalArgumentException exception
                )        {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }

        @ExceptionHandler(BookNotFoundException.class)
        public ResponseEntity<String> handleNotFound(
                BookNotFoundException exception) {

            return ResponseEntity.status(404)
                    .body(exception.getMessage());
        }
        return ResponseEntity.notFound().build();
    }
}
