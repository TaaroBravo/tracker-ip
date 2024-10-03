package com.lautarobravo.tracipapi.infrastructure.dtos.geolocalization;

public class CountryResponse{
    public String name;
    public String code;

    public CountryResponse(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
