package com.skillUp.currencyexchange.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillUp.currencyexchange.beans.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Integer> {

}
