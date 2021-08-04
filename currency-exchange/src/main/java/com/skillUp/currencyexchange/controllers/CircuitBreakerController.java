package com.skillUp.currencyexchange.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	private final Logger logger=LoggerFactory.getLogger(CircuitBreakerController.class);
	@GetMapping("/sampleApi")
	@Retry(name = "sample-api", fallbackMethod = "fallbackResponse")
	public String sampleApi() {
		logger.info("*************access sample API*************");
		ResponseEntity<String> response= new RestTemplate().getForEntity("http://localhost:8080/sample", String.class);
		return response.getBody();
	}
	
	public String fallbackResponse(Exception e) {
		return "FALLBACK RESPONSE";
	}
}
