package com.lautarobravo.tracipapi.infrastructure.dtos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lautarobravo.tracipapi.domain.model.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;
import java.util.ArrayList;

@Entity
@NoArgsConstructor
public class GeoLocalizationDTO {

    @Id
    private String ip;
    private String countryName;
    private String countryCode;
    private String languages;
    private String position;

    public GeoLocalizationDTO(String ip, String countryName, String countryCode, String languages, String position) {

        this.ip = ip;
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.languages = languages;
        this.position = position;
    }

    public static GeoLocalizationDTO from(GeoLocalization geoLocalization){

        Gson gson = new Gson();

        var languages = new GeoLocalizationLanguagesDTO(geoLocalization.getLanguages());
        return new GeoLocalizationDTO(geoLocalization.getIp(),
                geoLocalization.getCountryName(),
                geoLocalization.getCountryCode(),
                gson.toJson(languages),
                gson.toJson(geoLocalization.getPosition()));
    }

    public GeoLocalization toModel(){
        Gson gson = new Gson();

        return new GeoLocalization(ip, countryName, countryCode, gson.fromJson(this.languages, GeoLocalizationLanguagesDTO.class).languages, gson.fromJson(this.position, CoordinatePosition.class));
    }
}
