package com.lautarobravo.tracipapi.domain.repositories;

import com.lautarobravo.tracipapi.infrastructure.dtos.countrydata.CountryData;

import java.util.List;

public interface CountryDataRepository {

    boolean hasWith(String code);
    CountryData get(String code);
    void add(CountryData country);
    void set(List<CountryData> countries);
}
