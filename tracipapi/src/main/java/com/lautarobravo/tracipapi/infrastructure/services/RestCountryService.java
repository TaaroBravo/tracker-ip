package com.lautarobravo.tracipapi.infrastructure.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lautarobravo.tracipapi.infrastructure.dtos.countrydata.CountryData;
import com.lautarobravo.tracipapi.domain.repositories.CountryDataRepository;
import com.lautarobravo.tracipapi.domain.services.CountryService;
import com.lautarobravo.tracipapi.infrastructure.dtos.countrydata.CountryLayerResponse;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class RestCountryService implements CountryService {
    private final String path = "https://restcountries.com/v2/all";
    private final CountryDataRepository countryDataRepository;

    @Autowired
    public RestCountryService(CountryDataRepository countryDataRepository) {
        this.countryDataRepository = countryDataRepository;
    }

    @Override
    public CountryData get(String codeSymbol) throws UnirestException, JsonProcessingException {

        if(countryDataRepository.findById(codeSymbol).isEmpty()){
            HttpResponse<JsonNode> response = Unirest.get(path).asJson();
            ObjectMapper om = new ObjectMapper();
            CountryLayerResponse[] countriesLayerResponses = om.readValue(response.getBody().toString(), CountryLayerResponse[].class);

            List<CountryData> countriesDatas = Arrays.stream(countriesLayerResponses)
                    .map(CountryLayerResponse::toCountryData)
                    .toList();

            countryDataRepository.saveAll(countriesDatas);
        }

        return countryDataRepository.findById(codeSymbol)
                .orElseThrow(() -> new RuntimeException("Did not find country data with " + codeSymbol));
    }
}
