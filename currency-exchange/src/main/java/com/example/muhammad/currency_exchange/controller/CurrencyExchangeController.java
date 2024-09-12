package com.example.muhammad.currency_exchange.controller;

import com.example.muhammad.currency_exchange.dto.CurrencyExchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @GetMapping(path = "/currency-exchange/{from}/to/{to}")
    public CurrencyExchange retrieveCurrencyExchangeValue(@PathVariable String from,
                                                          @PathVariable String to) {
        return new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(3.7));
    }
}
