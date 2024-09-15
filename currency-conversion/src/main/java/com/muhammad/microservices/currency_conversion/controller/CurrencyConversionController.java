package com.muhammad.microservices.currency_conversion.controller;

import com.muhammad.microservices.currency_conversion.dto.CurrencyConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion retrieveCurrencyConversion(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable BigDecimal quantity){
        return new CurrencyConversion(10000L, from, to, quantity,
                BigDecimal.ONE, BigDecimal.ONE, "");
    }

}
