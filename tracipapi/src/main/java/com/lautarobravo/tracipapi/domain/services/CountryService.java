package com.lautarobravo.tracipapi.domain.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lautarobravo.tracipapi.infrastructure.dtos.countrydata.CountryData;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface CountryService{
    CountryData get(String symbol) throws UnirestException, JsonProcessingException;
}
