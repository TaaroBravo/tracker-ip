package com.lautarobravo.tracipapi.infrastructure.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lautarobravo.tracipapi.domain.model.CountryDetails;
import com.lautarobravo.tracipapi.domain.repositories.CountryDetailsRepository;
import com.lautarobravo.tracipapi.domain.services.CountryService;
import com.lautarobravo.tracipapi.infrastructure.dtos.CountryDetailsDTO;
import com.lautarobravo.tracipapi.infrastructure.responses.countrydata.CountryLayerResponse;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RestCountryService implements CountryService {
    private final String path = "https://restcountries.com/v2/all";
    private final CountryDetailsRepository countryDataRepository;

    @Autowired
    public RestCountryService(CountryDetailsRepository countryDataRepository) {
        this.countryDataRepository = countryDataRepository;
    }

    @Override
    public CountryDetails get(String codeSymbol) throws UnirestException, JsonProcessingException {

        if(countryDataRepository.findById(codeSymbol).isEmpty()){
            HttpResponse<JsonNode> response = Unirest.get(path).asJson();
            ObjectMapper om = new ObjectMapper();
            CountryLayerResponse[] countriesLayerResponses = om.readValue(response.getBody().toString(), CountryLayerResponse[].class);

            List<CountryDetails> countriesDatas = Arrays.stream(countriesLayerResponses)
                    .map(CountryLayerResponse::toCountryData)
                    .toList();

            countryDataRepository.saveAll(countriesDatas.stream().map(CountryDetailsDTO::from).toList());
        }

        return countryDataRepository.findById(codeSymbol)
                .map(CountryDetailsDTO::toModel)
                .orElseThrow(() -> new RuntimeException("Did not find country data with " + codeSymbol));
    }
}
