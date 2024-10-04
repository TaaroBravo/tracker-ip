package com.lautarobravo.tracipapi.domain.repositories;

import com.lautarobravo.tracipapi.domain.model.Distance;
import org.springframework.data.repository.CrudRepository;

public interface DistancesRepository extends CrudRepository<Distance, String> {
}
