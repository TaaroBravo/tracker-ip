package com.lautarobravo.tracipapi.domain.repositories;

import com.lautarobravo.tracipapi.domain.model.Distance;

import java.util.List;

public interface DistancesRepository {
    List<Distance> findAll();
    void save(Distance distance);
}
