package com.lautarobravo.tracipapi;

import com.lautarobravo.tracipapi.domain.repositories.CountryDetailsRepository;
import com.lautarobravo.tracipapi.infrastructure.dtos.CountryDetailsDTO;
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
public class CountryDetailsRepositoryIntegrationTest {

    @Autowired
    CacheManager cacheManager;

    @Autowired
    CountryDetailsRepository repository;

    @BeforeEach
    void Setup(){
        repository.save(new CountryDetailsDTO("AR", "", ""));
    }

    private Optional<CountryDetailsDTO> getCached(String id) {
        return ofNullable(cacheManager.getCache("countrydetails")).map(c -> c.get(id, CountryDetailsDTO.class));
    }

    @Test
    void get_cached_when_info_is_cached() {
        Optional<CountryDetailsDTO> cached = repository.findById("AR");

        assertEquals(cached, getCached("AR"));
    }

    @Test
    void get_non_cached_when_info_is_not_cached() {
        repository.findById("USA");

        assertEquals(empty(), getCached("USA"));
    }
}
