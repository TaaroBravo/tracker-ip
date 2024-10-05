package com.lautarobravo.tracipapi.domain.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lautarobravo.tracipapi.domain.model.CountryDetails;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface CountryService{
    CountryDetails get(String symbol) throws UnirestException, JsonProcessingException;
}
