package com.lautarobravo.tracipapi.domain.repositories;

import com.lautarobravo.tracipapi.infrastructure.dtos.DistanceDTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistancesRepository extends CrudRepository<DistanceDTO, String> {
    @Cacheable(value = "distances")
    Optional<DistanceDTO> findById(String id);
}
