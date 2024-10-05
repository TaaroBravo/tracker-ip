package com.lautarobravo.tracipapi.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
public class CountryDetails implements Serializable {
    @Id
    public String isoCode;
    public List<Symbol> currencies;
    public List<String> timezones;

    public CountryDetails(String isoCode, List<Symbol> currencies, List<String> timezones) {

        this.isoCode = isoCode;
        this.currencies = currencies;
        this.timezones = timezones;
    }

    public static CountryDetails from(String isoCode, List<Symbol> currencies, List<String> timezones) {
        return new CountryDetails(isoCode, currencies, timezones);
    }

}
