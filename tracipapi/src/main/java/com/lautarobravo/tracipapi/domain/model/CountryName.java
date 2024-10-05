package com.lautarobravo.tracipapi.domain.model;

public class CountryName {
    private String name;
    private String code;
    private String isoCode;

    public CountryName(String name, String code, String isoCode) {
        this.name = name;
        this.code = code;
        this.isoCode = isoCode;
    }

    public static CountryName from(String name, String code, String isoCode) {
        return new CountryName(name, code, isoCode);
    }

    @Override
    public String toString() {
        return name + "("+ code +")" + " isocode: " + isoCode;
    }

    public String getCode(){
        return code;
    }
}
