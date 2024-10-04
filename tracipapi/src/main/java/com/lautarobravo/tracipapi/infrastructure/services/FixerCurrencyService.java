package com.lautarobravo.tracipapi.infrastructure.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lautarobravo.tracipapi.domain.model.Currency;
import com.lautarobravo.tracipapi.domain.model.Symbol;
import com.lautarobravo.tracipapi.domain.repositories.CurrencyRepository;
import com.lautarobravo.tracipapi.domain.services.CurrencyService;
import com.lautarobravo.tracipapi.infrastructure.dtos.currency.FixerResponse;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FixerCurrencyService implements CurrencyService {

    String basePath = "https://v6.exchangerate-api.com/v6/d6e80d7282bf7ecfff53a91b/latest/USD";
    private final CurrencyRepository currencyRepository;

    @Autowired
    public FixerCurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Currency get(Symbol currencySymbol) throws UnirestException, JsonProcessingException {
        if(currencyRepository.findById(currencySymbol).isPresent())
            return currencyRepository.findById(currencySymbol)
                    .orElseThrow(() -> new RuntimeException("Did not find the currency by symbol"));
        else{
            HttpResponse<JsonNode> response = Unirest.get(basePath).asJson();
            FixerResponse fixerResponse = FixerResponse.from(response.getBody().toString());

            Currency currency = fixerResponse.toCurrency(currencySymbol);
            currencyRepository.save(currency);
            return currency;
        }
    }
}
