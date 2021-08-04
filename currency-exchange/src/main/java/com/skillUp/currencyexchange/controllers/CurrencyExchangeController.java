package com.skillUp.currencyexchange.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.skillUp.currencyexchange.beans.CurrencyExchange;
@RestController
public class CurrencyExchangeController {
	@Autowired
	Environment env;
	private final Logger logger=LoggerFactory.getLogger(CurrencyExchangeController.class);
@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
	CurrencyExchange currencyExchange=new CurrencyExchange(1001,from,to,50);
	currencyExchange.setEnvironment(env.getProperty("server.port"));
	logger.info("*************************CURRENCY EXCHANGE SERVICE *********************");
	return currencyExchange;
	}
}
