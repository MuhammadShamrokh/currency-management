package com.example.muhammad.currency_exchange.services;

import com.example.muhammad.currency_exchange.dao.CurrencyExchangeRepository;
import com.example.muhammad.currency_exchange.dto.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyExchangeService {
    private final CurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    public CurrencyExchangeService(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    public Optional<CurrencyExchange> retrieveCurrencyExchangeByFromAndTo(String from, String to){
        return Optional.ofNullable(currencyExchangeRepository.findByFromAndTo(from, to));
    }
}
