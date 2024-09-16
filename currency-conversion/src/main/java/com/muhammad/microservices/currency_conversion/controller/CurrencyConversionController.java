package com.muhammad.microservices.currency_conversion.controller;

import com.muhammad.microservices.currency_conversion.dto.CurrencyConversion;
import com.muhammad.microservices.currency_conversion.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;


@RestController
public class CurrencyConversionController {
    private final CurrencyExchangeProxy currencyExchangeProxy;

    @Autowired
    public CurrencyConversionController(CurrencyExchangeProxy currencyExchangeProxy) {
        this.currencyExchangeProxy = currencyExchangeProxy;
    }

    @GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion retrieveCurrencyConversion(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable BigDecimal quantity){

        // sending request using CurrencyExchangeProxy
        CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveCurrencyExchangeValue(from,to);

        // setting the missing values for currencyConversion
        currencyConversion.setQuantity(quantity);
        currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));

        return currencyConversion;
    }

}
