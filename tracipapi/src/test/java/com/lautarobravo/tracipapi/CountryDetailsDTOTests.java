package com.lautarobravo.tracipapi;

import com.lautarobravo.tracipapi.domain.model.CountryDetails;
import com.lautarobravo.tracipapi.domain.model.Symbol;
import com.lautarobravo.tracipapi.infrastructure.dtos.CountryDetailsDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryDetailsDTOTests {

    @Test
    void serialize_and_deserialize(){
        Symbol currency = Symbol.create("EUR", "EURO", "$");
        List<Symbol> currencies = List.of(currency);
        List<String> timezones = List.of("UTC-3");
        CountryDetails countryDetails = new CountryDetails("es", currencies, timezones);
        var dto = CountryDetailsDTO.from(countryDetails);
        var actualCountryDetails = dto.toModel();
        assertEquals(actualCountryDetails.isoCode, countryDetails.isoCode);
        assertEquals(actualCountryDetails.currencies.get(0), countryDetails.currencies.get(0));
        assertEquals(actualCountryDetails.timezones.get(0), countryDetails.timezones.get(0));
    }
}
