package com.lautarobravo.tracipapi.domain.repositories;

import com.lautarobravo.tracipapi.infrastructure.dtos.GeoLocalizationDTO;
import org.springframework.data.repository.CrudRepository;

public interface GeoLocalizationRepository extends CrudRepository<GeoLocalizationDTO, String> {
}

