package com.lautarobravo.tracipapi.domain.model;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Hour {
    private final String hour;

    public Hour(String hour) {
        this.hour = hour;
    }

    public static Hour from(String hour) {
        return new Hour(ZonedDateTime.now(ZoneId.of(hour)).toString());
    }

    @Override
    public String toString() {
        return hour;
    }
}
