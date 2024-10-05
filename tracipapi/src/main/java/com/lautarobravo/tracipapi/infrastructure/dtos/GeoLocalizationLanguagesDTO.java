package com.lautarobravo.tracipapi.infrastructure.dtos;

import com.lautarobravo.tracipapi.domain.model.Language;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class GeoLocalizationLanguagesDTO {
    List<Language> languages;

    public GeoLocalizationLanguagesDTO(List<Language> languages) {
        this.languages = languages;
    }
}
