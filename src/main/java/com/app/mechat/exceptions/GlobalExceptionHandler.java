package com.app.mechat.exceptions;

import com.app.mechat.primitives.Error;
import com.app.mechat.primitives.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Result<Void>> handleNotFound(NotFoundException ex){
        Error error = new Error("NOT_FOUND", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Result.<Void>failure(error));
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Result<Void>> handleConflictException(ConflictException ex){
        System.out.println("GLOBAL CONFLICT HANDLER REACHED: " + ex.getClass().getName());
        Error error = new Error("CONFLICT", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Result.<Void>failure(error));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Result<Void>> handleBadRequestException(BadRequestException ex){
        Error error = new Error("BAD_REQUEST", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Result.<Void>failure(error));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<Void>> handleAllExceptions(Exception ex) {

        logger.error("An unexpected error occurred", ex);

        Error error = new Error("SERVER_ERROR", "An unexpected error occurred");

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Result.<Void>failure(error));
    }
}
