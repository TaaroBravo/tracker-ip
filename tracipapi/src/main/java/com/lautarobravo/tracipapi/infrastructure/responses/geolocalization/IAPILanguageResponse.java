package com.lautarobravo.tracipapi.infrastructure.responses.geolocalization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lautarobravo.tracipapi.domain.model.Language;

public class IAPILanguageResponse {
    public String code;
    @JsonProperty("native")
    public String mynative;
    public String name;

    public Language toResponse() {
        return new Language(name, code);
    }
}
