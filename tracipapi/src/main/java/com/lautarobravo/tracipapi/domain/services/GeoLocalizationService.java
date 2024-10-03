package com.lautarobravo.tracipapi.domain.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lautarobravo.tracipapi.infrastructure.dtos.geolocalization.GeoLocalizationData;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface GeoLocalizationService{
    GeoLocalizationData get(String ip) throws JsonProcessingException, UnirestException;
}
