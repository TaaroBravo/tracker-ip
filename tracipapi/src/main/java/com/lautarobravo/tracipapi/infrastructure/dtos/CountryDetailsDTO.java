package com.lautarobravo.tracipapi.infrastructure.dtos;

import com.google.gson.Gson;
import com.lautarobravo.tracipapi.domain.model.CountryDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@NoArgsConstructor
public class CountryDetailsDTO implements Serializable {

    @Id
    public String isoCode;
    public String currencies;
    public String timezones;

    public CountryDetailsDTO(String isoCode, String currencies, String timezones) {
        this.isoCode = isoCode;
        this.currencies = currencies;
        this.timezones = timezones;
    }

    public static CountryDetailsDTO from(CountryDetails countryDetails){
        Gson gson = new Gson();
        var countryDetailsSymbolDto= new CountryDetailsSymbolDTO(countryDetails.currencies);
        var countryDetailsTimezonesDto = new CountryDetailsTimezonesDTO(countryDetails.timezones);
        return new CountryDetailsDTO(countryDetails.isoCode, gson.toJson(countryDetailsSymbolDto), gson.toJson(countryDetailsTimezonesDto));
    }

    public CountryDetails toModel(){
        Gson gson = new Gson();

        return new CountryDetails(isoCode, gson.fromJson(this.currencies, CountryDetailsSymbolDTO.class).currencies, gson.fromJson(this.timezones, CountryDetailsTimezonesDTO.class).timezones);
    }
}
