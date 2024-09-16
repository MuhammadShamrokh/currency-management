package com.muhammad.microservices.currency_conversion.proxy;

import com.muhammad.microservices.currency_conversion.dto.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange", url = "localhost:8000")
public interface CurrencyExchangeProxy {
    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion retrieveCurrencyExchangeValue(@PathVariable String from,
                                                     @PathVariable String to);

}
