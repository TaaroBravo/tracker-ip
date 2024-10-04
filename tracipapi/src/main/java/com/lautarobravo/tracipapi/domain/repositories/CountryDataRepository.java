package com.lautarobravo.tracipapi.domain.repositories;

import com.lautarobravo.tracipapi.infrastructure.dtos.countrydata.CountryData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryDataRepository extends CrudRepository<CountryData, String> {
}
