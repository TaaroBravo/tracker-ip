package com.lautarobravo.tracipapi.infrastructure.responses.countrydata;

import com.lautarobravo.tracipapi.domain.model.Symbol;

public class SymbolResponse {
    public String code;
    public String name;
    public String symbol;

    public Symbol toModel() {
        return Symbol.create(code,name,symbol);
    }
}
