package com.finki.lab1.controllers.utils;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class ResponseEntityWrapper {
    public static <T> ResponseEntity<T> createResponse(T result) {
        if (result == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    public static <T> ResponseEntity<T> createResponse(Optional<T> result) {
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
