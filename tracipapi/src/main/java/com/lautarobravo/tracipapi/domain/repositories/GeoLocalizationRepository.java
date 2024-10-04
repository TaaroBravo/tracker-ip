package com.lautarobravo.tracipapi.domain.repositories;

import com.lautarobravo.tracipapi.infrastructure.dtos.geolocalization.GeoLocalizationData;
import org.springframework.data.repository.CrudRepository;

public interface GeoLocalizationRepository extends CrudRepository<GeoLocalizationData, String> {
}

