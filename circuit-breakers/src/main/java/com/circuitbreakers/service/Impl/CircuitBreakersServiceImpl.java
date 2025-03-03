package com.circuitbreakers.service.Impl;

import com.circuitbreakers.service.CircuitBreakersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CircuitBreakersServiceImpl implements CircuitBreakersService {
    @Override
    public ResponseEntity<String> circuitBreakerApiTest() {
        return new RestTemplate().getForEntity("http://localhost:8081/test", String.class);
    }
    @Override
    public ResponseEntity<String> retryApiTesting() {
        return new RestTemplate().getForEntity("http://localhost:8081/test", String.class);
    }
    @Override
    public ResponseEntity<String> getCustomError(Throwable throwable) {
        return new ResponseEntity<String>("TestApi service is down and fallbackMethod  is call ", HttpStatus.NOT_FOUND);

    }
}
