package com.muhammad.microservices.currency_conversion.controller;

import com.muhammad.microservices.currency_conversion.dto.CurrencyConversion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    private final RestTemplate restTemplate;

    public CurrencyConversionController() {
        restTemplate = new RestTemplate();
    }


    @GetMapping("/hello")
    public String sayHello(){
        return "Hello-World";
    }

    @GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion retrieveCurrencyConversion(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable BigDecimal quantity){

        // preparing query params for the request
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("from", from);
        queryParams.put("to", to);

        // sending the request
        ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class,
                queryParams
        );

        // extracting the response body content
        CurrencyConversion currencyConversion = responseEntity.getBody();

        // setting the missing values for currencyConversion
        currencyConversion.setQuantity(quantity);
        currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()));

        return currencyConversion;
    }

}
