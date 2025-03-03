1) http://localhost:8080/circuit-breaker 
    -- if test-service is down then call the fallback method
3) http://localhost:8080/retry-api
 -- if test-service is down then call retry api 3 times
4) http://localhost:8080/actuator/circuitbreakers
    -- check the health  
