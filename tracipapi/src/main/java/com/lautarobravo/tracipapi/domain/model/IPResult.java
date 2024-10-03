package com.lautarobravo.tracipapi.domain.model;

import java.util.Date;
import java.util.List;

public class IPResult {

    private String ip;
    private Country country;
    private List<Language> languages;
    private CoordinatePosition position;
    private List<Currency> currencies;
    private Date date;
    private List<Hour> hour;
    private Distance distance;
    private Distance longestDistanceToBsAs;
    private Distance lowerDistanceToBsAs;
    private Distance averageDistanceToBsAs;

    public IPResult(String ip,
                    Country country,
                    List<Language> languages,
                    CoordinatePosition position,
                    List<Currency> currency,
                    Date date,
                    List<Hour> hour,
                    Distance distance,
                    Distance longestDistanceToBsAs,
                    Distance lowerDistanceToBsAs,
                    Distance averageDistanceToBsAs) {
        this.ip = ip;
        this.country = country;
        this.languages = languages;
        this.position = position;
        this.currencies = currency;
        this.date = date;
        this.hour = hour;
        this.distance = distance;
        this.longestDistanceToBsAs = longestDistanceToBsAs;
        this.lowerDistanceToBsAs = lowerDistanceToBsAs;
        this.averageDistanceToBsAs = averageDistanceToBsAs;
    }

    public static IPResult from(String ip,
                                Country country,
                                List<Language> languages,
                                CoordinatePosition position,
                                List<Currency> currency,
                                Date date,
                                List<Hour> hour,
                                Distance distance,
                                Distance longestDistanceToBsAs,
                                Distance lowerDistanceToBsAs,
                                Distance averageDistanceToBsAs) {
        return new IPResult(ip,
                country,
                languages,
                position,
                currency,
                date,
                hour,
                distance, longestDistanceToBsAs, lowerDistanceToBsAs, averageDistanceToBsAs);
    }

    @Override
    public String toString() {
        return
                ip + "\n" +
                country.toString() + "\n" +
                "Languages: {" + transformLanguagesAsString() + "}\n" +
                "Coordinate Position: " + position.toString() + "\n" +
                "Currencies: {" + transformCurrenciesAsString() + "}\n" +
                "Date: " + date + "\n" +
                "Hours: {" + transformHoursAsString() + "}\n" +
                "Distance to Buenos Aires: " + distance.toString() + "\n" +
                "Longest Distance to Buenos Aires: " + longestDistanceToBsAs.toString() + "\n" +
                "Lowest Distance to Buenos Aires: " + lowerDistanceToBsAs.toString() + "\n" +
                "Average Distance to Buenos Aires: " + averageDistanceToBsAs.toString();
    }

    private String transformLanguagesAsString() {
        return String.join(",", languages
                .stream()
                .map(Language::toString)
                .toList());
    }

    private String transformCurrenciesAsString() {
        return String.join(",", currencies
                .stream()
                .map(Currency::toString)
                .toList());
    }

    private String transformHoursAsString() {
        return String.join(",", hour
                .stream()
                .map(Hour::toString)
                .toList());
    }

}

