package com.lautarobravo.tracipapi.infrastructure.dtos.geolocalization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lautarobravo.tracipapi.domain.model.CoordinatePosition;
import com.lautarobravo.tracipapi.domain.model.Language;

import java.util.ArrayList;
import java.util.List;

public class IAPIResponse {
    public String continent_name;
    public String zip;
    public String connection_type;
    public String city;
    public String ip;
    public double latitude;
    public String continent_code;
    public String type;
    public String ip_routing_type;
    public String country_code;
    public String country_name;
    public Object dma;
    public String region_name;
    public Object msa;
    public IAPILocation location;
    public String radius;
    public String region_code;
    public double longitude;

    public static IAPIResponse from(String json) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.readValue(json, IAPIResponse.class);
    }

    public GeoLocalizationData toGeoLocalization() {
        return GeoLocalizationData.from(ip, country_name, country_code, getLanguagesFrom(location.languages), CoordinatePosition.from(latitude, longitude));
    }

    private List<Language> getLanguagesFrom(ArrayList<IAPILanguage> languages){
        return languages
                .stream()
                .map(IAPILanguage::toResponse)
                .toList();
    }
}
