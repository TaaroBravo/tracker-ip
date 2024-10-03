package com.lautarobravo.tracipapi.domain.model;

public class Country{
    private String name;
    private String code;
    private String isoCode;

    public Country(String name, String code, String isoCode) {
        this.name = name;
        this.code = code;
        this.isoCode = isoCode;
    }

    public static Country from(String name, String code, String isoCode) {
        return new Country(name, code, isoCode);
    }

    @Override
    public String toString() {
        return name + "("+ code +")" + " isocode: " + isoCode;
    }

    public String getCode(){
        return code;
    }
}
