package com.lautarobravo.tracipapi;

import com.lautarobravo.tracipapi.infrastructure.repositories.DistancesRepository;
import com.lautarobravo.tracipapi.infrastructure.dtos.DistanceDTO;
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
public class DistancesRepositoryIntegrationTest {

    @Autowired
    CacheManager cacheManager;

    @Autowired
    DistancesRepository repository;

    @BeforeEach
    void Setup(){
        repository.save(new DistanceDTO("Argentina", 0.1));
    }

    private Optional<DistanceDTO> getCached(String id) {
        return ofNullable(cacheManager.getCache("distances")).map(c -> c.get(id, DistanceDTO.class));
    }

    @Test
    void get_cached_when_info_is_cached() {
        Optional<DistanceDTO> cached = repository.findById("Argentina");

        assertEquals(cached, getCached("Argentina"));
    }

    @Test
    void get_non_cached_when_info_is_not_cached() {
        repository.findById("Brasil");

        assertEquals(empty(), getCached("Brasil"));
    }
}
