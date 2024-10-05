package com.lautarobravo.tracipapi.infrastructure.repositories;

import com.lautarobravo.tracipapi.infrastructure.dtos.CountryDetailsDTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryDetailsRepository extends CrudRepository<CountryDetailsDTO, String> {
    @Cacheable(value = "countrydetails")
    Optional<CountryDetailsDTO> findById(String id);
}
