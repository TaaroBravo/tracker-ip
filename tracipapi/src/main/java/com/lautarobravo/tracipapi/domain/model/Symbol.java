package com.lautarobravo.tracipapi.domain.model;

import java.util.Objects;

public class Symbol {
    private String code;
    private String name;
    private String symbol;

    public Symbol(String code, String name, String symbol) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    public static Symbol create(String code, String name, String symbol) {
        return new Symbol(code, name, symbol);
    }

    @Override
    public String toString() {
        return symbol+code+" ("+name+")";
    }

    public boolean sameAs(String symbol) {
        return Objects.equals(code, symbol);
    }

    public String getCode() {
        return code;
    }
}
