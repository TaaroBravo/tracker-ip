package com.lautarobravo.tracipapi.domain.model;

import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class Language implements Serializable {
    private String code;
    private String name;

    public Language(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return name + "("+code+")";
    }
}

