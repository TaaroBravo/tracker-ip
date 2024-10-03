package com.lautarobravo.tracipapi.infrastructure.dtos.geolocalization;

public class LanguageResponse{
    public String code;
    public String name;

    public LanguageResponse(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
