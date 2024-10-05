package com.lautarobravo.tracipapi.infrastructure.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lautarobravo.tracipapi.domain.repositories.GeoLocalizationRepository;
import com.lautarobravo.tracipapi.domain.model.GeoLocalization;
import com.lautarobravo.tracipapi.domain.services.GeoLocalizationService;
import com.lautarobravo.tracipapi.infrastructure.dtos.GeoLocalizationDTO;
import com.lautarobravo.tracipapi.infrastructure.responses.geolocalization.IAPIResponse;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IAPIGeoLocalizationService implements GeoLocalizationService {

    private final GeoLocalizationRepository geoLocalizationRepository;

    @Autowired
    public IAPIGeoLocalizationService(GeoLocalizationRepository geoLocalizationRepository) {
        this.geoLocalizationRepository = geoLocalizationRepository;
    }

    public GeoLocalization get(String ip) throws JsonProcessingException, UnirestException {
        if(geoLocalizationRepository.findById(ip).isPresent())
            return geoLocalizationRepository.findById(ip)
                    .map(GeoLocalizationDTO::toModel)
                    .orElseThrow(() -> new RuntimeException("Did not find a geolocalizationdata with " + ip));
        else {
            HttpResponse<JsonNode> response = Unirest.get("http://api.ipapi.com/"+ip+"?access_key="+"9ac624c725ca0dc82c99814b9251f1d2").asJson();
            IAPIResponse iapiResponse = IAPIResponse.from(response.getBody().toString());
            GeoLocalization geoLocalization = iapiResponse.toGeoLocalization();
            geoLocalizationRepository.save(GeoLocalizationDTO.from(geoLocalization));
            return geoLocalization;
        }

    }
}
