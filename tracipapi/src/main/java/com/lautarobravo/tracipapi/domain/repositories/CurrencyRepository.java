package com.lautarobravo.tracipapi.domain.repositories;

import com.lautarobravo.tracipapi.infrastructure.dtos.CurrencyDTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends CrudRepository<CurrencyDTO, String> {
    @Cacheable(value = "currencies")
    Optional<CurrencyDTO> findById(String id);
}
