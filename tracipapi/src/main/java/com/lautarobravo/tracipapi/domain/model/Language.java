package com.lautarobravo.tracipapi.domain.model;

public class Language {
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

