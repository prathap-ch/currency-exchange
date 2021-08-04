package com.skillUp.currencyexchange.controllers;

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
@GetMapping("/currency-exchnage/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
	CurrencyExchange currencyExchange=new CurrencyExchange(1001,from,to,50);
	currencyExchange.setEnvironment(env.getProperty("server.port"));
	return currencyExchange;
	}
}
