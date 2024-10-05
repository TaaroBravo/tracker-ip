package com.lautarobravo.tracipapi.infrastructure.responses.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.lautarobravo.tracipapi.domain.model.Currency;
import com.lautarobravo.tracipapi.domain.model.Symbol;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixerResponse {
    public JsonNode conversion_rates;

    public Currency toCurrency(Symbol currencySymbol) {
        return Currency.from(currencySymbol, conversion_rates.get(currencySymbol.getCode()).asDouble());
    }

    public static FixerResponse from(String json) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.readValue(json, FixerResponse.class);
    }
}

