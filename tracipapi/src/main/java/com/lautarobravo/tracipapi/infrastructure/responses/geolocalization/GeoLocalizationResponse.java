package com.lautarobravo.tracipapi.infrastructure.responses.geolocalization;

import java.util.List;

public class GeoLocalizationResponse {

    private CountryResponse country;
    private List<LanguageResponse> languages;
    private CoordinatePositionResponse position;

    public GeoLocalizationResponse(CountryResponse country, List<LanguageResponse> languages, CoordinatePositionResponse position) {
        this.country = country;
        this.languages = languages;
        this.position = position;
    }

    public static GeoLocalizationResponse from(CountryResponse country, List<LanguageResponse> languages, CoordinatePositionResponse position) {
        return new GeoLocalizationResponse(country, languages, position);
    }

    @Override
    public String toString() {
        return country.toString()  + "\t" +
                getLanguages() + "\t" +
                position.toString();
    }

    private String getLanguages() {
        return String.join(",", languages
                .stream()
                .map(LanguageResponse::toString)
                .toList());
    }
}
