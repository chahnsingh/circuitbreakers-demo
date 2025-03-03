package com.circuitbreakers.service;

import org.springframework.http.ResponseEntity;

public interface CircuitBreakersService {
    ResponseEntity<String> circuitBreakerApiTest();
    ResponseEntity<String> retryApiTesting();
    ResponseEntity<String> getCustomError(Throwable throwable);
}
