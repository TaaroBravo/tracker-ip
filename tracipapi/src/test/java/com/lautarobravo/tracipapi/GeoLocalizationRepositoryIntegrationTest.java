package com.lautarobravo.tracipapi;

import com.lautarobravo.tracipapi.domain.repositories.DistancesRepository;
import com.lautarobravo.tracipapi.domain.repositories.GeoLocalizationRepository;
import com.lautarobravo.tracipapi.infrastructure.dtos.DistanceDTO;
import com.lautarobravo.tracipapi.infrastructure.dtos.GeoLocalizationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TracipapiApplication.class)
public class GeoLocalizationRepositoryIntegrationTest {

    @Autowired
    CacheManager cacheManager;

    @Autowired
    GeoLocalizationRepository repository;

    @BeforeEach
    void Setup(){
        repository.save(new GeoLocalizationDTO("0.00.0.0.1", "Argentina", "AR", "", ""));
    }

    private Optional<GeoLocalizationDTO> getCached(String ip) {
        return ofNullable(cacheManager.getCache("geolocalizations")).map(c -> c.get(ip, GeoLocalizationDTO.class));
    }

    @Test
    void get_cached_geolocalization_when_info_is_cached() {
        Optional<GeoLocalizationDTO> cached = repository.findById("0.00.0.0.1");

        assertEquals(cached, getCached("0.00.0.0.1"));
    }

    @Test
    void get_non_cached_when_info_is_not_cached() {
        repository.findById("0.00.0.0.2");

        assertEquals(empty(), getCached("0.00.0.0.2"));
    }
}

