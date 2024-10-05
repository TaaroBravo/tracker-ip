package com.lautarobravo.tracipapi.infrastructure.repositories;

import com.lautarobravo.tracipapi.infrastructure.dtos.GeoLocalizationDTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeoLocalizationRepository extends CrudRepository<GeoLocalizationDTO, String> {
    @Cacheable(value = "geolocalizations")
    Optional<GeoLocalizationDTO> findById(String id);
}

