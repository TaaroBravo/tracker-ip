package com.lautarobravo.tracipapi.domain.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lautarobravo.tracipapi.domain.model.Currency;
import com.lautarobravo.tracipapi.domain.model.Symbol;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface CurrencyService {
    Currency get(Symbol symbol) throws UnirestException, JsonProcessingException;
}
