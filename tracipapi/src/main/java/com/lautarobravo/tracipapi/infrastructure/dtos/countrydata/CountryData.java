package com.lautarobravo.tracipapi.infrastructure.dtos.countrydata;

import com.lautarobravo.tracipapi.domain.model.Symbol;

import java.util.List;

public class CountryData {

    public String isoCode;
    public List<Symbol> currencies;
    public List<String> timezones;

    public CountryData(String isoCode, List<Symbol> currencies, List<String> timezones) {

        this.isoCode = isoCode;
        this.currencies = currencies;
        this.timezones = timezones;
    }

    public static CountryData from(String isoCode, List<Symbol> currencies, List<String> timezones) {
        return new CountryData(isoCode, currencies, timezones);
    }

    public boolean hasSameCode(String code) {
        return isoCode.equals(code);
    }

    public String getIsoCode() {
        return isoCode;
    }
}
