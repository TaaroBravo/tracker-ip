package com.lautarobravo.tracipapi.infrastructure.dtos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lautarobravo.tracipapi.domain.model.CountryDetails;
import com.lautarobravo.tracipapi.domain.model.Currency;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

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

        return new CountryDetailsDTO(countryDetails.isoCode, gson.toJson(countryDetails.currencies), gson.toJson(countryDetails.timezones));
    }

    public CountryDetails toModel(){
        Gson gson = new Gson();
        Type currenciesType = new TypeToken<ArrayList<Currency>>(){}.getType();
        Type timezonesType= new TypeToken<ArrayList<String>>(){}.getType();

        return new CountryDetails(isoCode, gson.fromJson(this.currencies, currenciesType), gson.fromJson(this.timezones, timezonesType));
    }
}
