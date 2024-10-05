package com.lautarobravo.tracipapi.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
public class GeoLocalization implements Serializable {
    @Id
    private String ip;
    private String countryName;
    private String countryCode;
    private List<Language> languages;
    private CoordinatePosition position;

    public GeoLocalization(String ip, String countryName, String countryCode, List<Language> languages, CoordinatePosition position) {
        this.ip = ip;
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.languages = languages;
        this.position = position;
    }

    public static GeoLocalization from(String ip, String countryName, String countryCode, List<Language> languages, CoordinatePosition position) {
        return new GeoLocalization(ip, countryName, countryCode, languages, position);
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

