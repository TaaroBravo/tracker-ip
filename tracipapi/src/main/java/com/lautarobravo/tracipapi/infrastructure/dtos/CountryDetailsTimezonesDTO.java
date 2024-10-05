package com.lautarobravo.tracipapi.infrastructure.dtos;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class CountryDetailsTimezonesDTO {
    public List<String> timezones;

    public CountryDetailsTimezonesDTO(List<String> timezones) {
        this.timezones = timezones;
    }
}
