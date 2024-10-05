package com.lautarobravo.tracipapi.infrastructure.dtos;

import com.lautarobravo.tracipapi.domain.model.Symbol;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class CountryDetailsSymbolDTO {
    public List<Symbol> currencies;

    public CountryDetailsSymbolDTO(List<Symbol> currencies) {
        this.currencies = currencies;
    }
}

