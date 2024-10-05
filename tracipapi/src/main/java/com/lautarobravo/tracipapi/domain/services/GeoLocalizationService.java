package com.lautarobravo.tracipapi.domain.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lautarobravo.tracipapi.domain.model.GeoLocalization;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface GeoLocalizationService{
    GeoLocalization get(String ip) throws JsonProcessingException, UnirestException;
}
