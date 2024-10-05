package com.lautarobravo.tracipapi;

import com.lautarobravo.tracipapi.infrastructure.repositories.CurrencyRepository;
import com.lautarobravo.tracipapi.infrastructure.dtos.CurrencyDTO;
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
public class CurrencyRepositoryIntegrationTest {

    @Autowired
    CacheManager cacheManager;

    @Autowired
    CurrencyRepository repository;

    @BeforeEach
    void Setup(){
        repository.save(new CurrencyDTO("AR", "Pesos", "$", 900));
    }

    private Optional<CurrencyDTO> getCached(String id) {
        return ofNullable(cacheManager.getCache("currencies")).map(c -> c.get(id, CurrencyDTO.class));
    }

    @Test
    void get_cached_when_info_is_cached() {
        Optional<CurrencyDTO> cached = repository.findById("AR");

        assertEquals(cached, getCached("AR"));
    }

    @Test
    void get_non_cached_when_info_is_not_cached() {
        repository.findById("USD");

        assertEquals(empty(), getCached("USD"));
    }
}
