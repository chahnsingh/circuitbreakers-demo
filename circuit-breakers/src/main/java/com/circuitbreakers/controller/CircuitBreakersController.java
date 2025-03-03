package com.circuitbreakers.controller;

import com.circuitbreakers.service.CircuitBreakersService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakersController {
    private final CircuitBreakersService circuitBreakersService;

    @Autowired
    public CircuitBreakersController(CircuitBreakersService circuitBreakersService){
        this.circuitBreakersService = circuitBreakersService;
    }

    /**
     *  call the CircuitBreakersService method name is circuitBreakerApiTest if service is down then call the by default method getCustomError()
     * @return :  ResponseEntity<String>
     */
    @GetMapping("/circuit-breaker")
    @CircuitBreaker(name = "CircuitBreakerServiceTesting", fallbackMethod = "getCustomError")
    ResponseEntity<String> circuitBreakerTest() {
        System.out.println("circuit-breaker call ");
      return circuitBreakersService.circuitBreakerApiTest();
    }

    /**
     * call the CircuitBreakersService method name is retryApiTesting if service is down then call the by default method getCustomError()
     * @return :  ResponseEntity<String>
     */
    @GetMapping("/retry-api")
    @Retry(name = "retry-api-service", fallbackMethod = "getCustomError")
    ResponseEntity<String> retryApiTesting() {
        System.out.println("retry-api method call ");
        return circuitBreakersService.circuitBreakerApiTest();
    }

    /**
     *  method call by fallbackMethod
     * @param throwable : Throwable
     * @return : ResponseEntity<String>
     */
    public ResponseEntity<String> getCustomError(Throwable throwable) {
       return circuitBreakersService.getCustomError(throwable);
    }


}
