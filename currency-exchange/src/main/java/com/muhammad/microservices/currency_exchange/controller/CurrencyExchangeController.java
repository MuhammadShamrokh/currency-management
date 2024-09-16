package com.muhammad.microservices.currency_exchange.controller;

import java.util.Optional;

import com.muhammad.microservices.currency_exchange.dto.CurrencyExchange;
import com.muhammad.microservices.currency_exchange.services.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

@RestController
public class CurrencyExchangeController {
    private final CurrencyExchangeService currencyExchangeService;
    private final Environment environment;

    @Autowired
    public CurrencyExchangeController(Environment environment, CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
        this.environment = environment;
    }

    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveCurrencyExchangeValue(@PathVariable String from,
                                                          @PathVariable String to) {

        //retrieving CurrencyExchangeEntry from database
        Optional<CurrencyExchange> currencyExchangeOptional = currencyExchangeService.retrieveCurrencyExchangeByFromAndTo(from, to);
        CurrencyExchange currencyExchange = currencyExchangeOptional.orElseThrow(()->
                new RuntimeException(String.format("No currency exchange from %s to %s",from, to)));

        // retrieving server port from environment instance
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}
