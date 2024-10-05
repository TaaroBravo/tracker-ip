package com.lautarobravo.tracipapi.domain.repositories;

import com.lautarobravo.tracipapi.infrastructure.dtos.CountryDetailsDTO;
import org.springframework.data.repository.CrudRepository;

public interface CountryDetailsRepository extends CrudRepository<CountryDetailsDTO, String> {
}
