package com.lautarobravo.tracipapi.domain.repositories;

import com.lautarobravo.tracipapi.infrastructure.dtos.geolocalization.GeoLocalizationData;

public interface GeoLocalizationRepository {
    boolean hasWith(String ip);
    GeoLocalizationData get(String ip);
    void set(GeoLocalizationData data);
    void set(GeoLocalizationData[] datas);
}

