package com.lautarobravo.tracipapi.infrastructure.dtos.geolocalization;

import com.lautarobravo.tracipapi.domain.model.CoordinatePosition;
import com.lautarobravo.tracipapi.domain.model.Language;

import java.util.List;

public class GeoLocalizationData {
    private final String ip;
    private final String countryName;
    private final String countryCode;
    private final List<Language> languages;
    private final CoordinatePosition position;

    public GeoLocalizationData(String ip, String countryName, String countryCode, List<Language> languages, CoordinatePosition position) {
        this.ip = ip;
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.languages = languages;
        this.position = position;
    }

    public static GeoLocalizationData from(String ip,String countryName, String countryCode, List<Language> languages, CoordinatePosition position) {
        return new GeoLocalizationData(ip, countryName, countryCode, languages, position);
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public List<Language> getLanguages(){
        return languages;
    }

    public CoordinatePosition getPosition() {
        return position;
    }

    public boolean hasIp(String ip) {
        return this.ip.equals(ip);
    }

    public String getIp() {
        return ip;
    }
}

