package com.lautarobravo.tracipapi.domain.repositories;

import com.lautarobravo.tracipapi.infrastructure.dtos.DistanceDTO;
import org.springframework.data.repository.CrudRepository;

public interface DistancesRepository extends CrudRepository<DistanceDTO, String> {
}
