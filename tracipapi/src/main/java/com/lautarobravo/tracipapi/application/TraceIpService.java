package com.lautarobravo.tracipapi.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lautarobravo.tracipapi.domain.model.*;
import com.lautarobravo.tracipapi.domain.services.CountryService;
import com.lautarobravo.tracipapi.infrastructure.services.DistanceService;
import com.lautarobravo.tracipapi.domain.model.CountryDetails;
import com.lautarobravo.tracipapi.domain.model.GeoLocalization;
import com.lautarobravo.tracipapi.domain.services.CurrencyService;
import com.lautarobravo.tracipapi.domain.services.GeoLocalizationService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class TraceIpService {

    private final GeoLocalizationService geoLocalizationService;
    private final CurrencyService currencyService;
    private final CountryService countryService;
    private final DistanceService distanceService;

    @Autowired
    public TraceIpService(GeoLocalizationService geoLocalizationService,
                          CurrencyService currencyService,
                          CountryService countryService,
                          DistanceService distanceService) {
        this.geoLocalizationService = geoLocalizationService;
        this.currencyService = currencyService;
        this.countryService = countryService;
        this.distanceService = distanceService;
    }

    public String getBy(String ip) throws UnirestException, JsonProcessingException {

        GeoLocalization geoLocalization = geoLocalizationService.get(ip);
        CountryDetails countrySpecifics = countryService.get(geoLocalization.getCountryCode());

        List<Currency> currencies = getCurrencies(countrySpecifics);

        List<Hour> hours = countrySpecifics.timezones
                .stream()
                .map(Hour::from)
                .toList();

        GeoLocalization bsAs = geoLocalizationService.get("181.31.0.46");

        Distance distanceToBsAs = Distance.from(geoLocalization.getCountryName(), geoLocalization.getPosition(), bsAs.getPosition());

        distanceService.save(distanceToBsAs);

        return IPDetails.from(ip,
                CountryName.from(geoLocalization.getCountryName(), geoLocalization.getCountryCode(), countrySpecifics.isoCode),
                geoLocalization.getLanguages(),
                geoLocalization.getPosition(),
                currencies,
                Date.valueOf(LocalDate.now()),
                hours,
                distanceToBsAs,
                distanceService.getMinDistance(),
                distanceService.getMaxDistance(),
                distanceService.getAverageDistance())
                .toString();
    }

    private @NotNull List<Currency> getCurrencies(CountryDetails countrySpecifics) throws UnirestException, JsonProcessingException {

        List<Currency> currencies = new ArrayList<>();
        for(Symbol symbol : countrySpecifics.currencies)
        {
            Currency currency = currencyService.get(symbol);
            currencies.add(currency);
        }
        return currencies;
    }

}

