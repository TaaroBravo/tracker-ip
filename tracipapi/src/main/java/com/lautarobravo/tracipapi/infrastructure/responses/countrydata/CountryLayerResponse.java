package com.lautarobravo.tracipapi.infrastructure.responses.countrydata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lautarobravo.tracipapi.domain.model.CountryDetails;
import com.lautarobravo.tracipapi.domain.model.Symbol;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryLayerResponse {
    public String name;
    public String alpha2Code;
    public ArrayList<SymbolResponse> currencies;
    public ArrayList<String> timezones;

    public static CountryLayerResponse from(String json) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.readValue(json, CountryLayerResponse.class);
    }

    public static CountryLayerResponse Invalid() {
        return new CountryLayerResponse();
    }

    public CountryDetails toCountryData() {
        return CountryDetails.from(alpha2Code,
                mapCurrencies(),
                timezones.stream().toList());
    }

    private List<Symbol> mapCurrencies() {
        if(currencies == null)
            return new ArrayList<Symbol>();
        return currencies.stream().map(SymbolResponse::toModel).toList();
    }
}
