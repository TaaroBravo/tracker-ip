package com.lautarobravo.tracipapi.domain.repositories;

import com.lautarobravo.tracipapi.domain.model.Currency;
import com.lautarobravo.tracipapi.domain.model.Symbol;

public interface CurrencyRepository {

    boolean hasWith(Symbol symbol);
    Currency get(Symbol symbol);
    void set(Currency currency);
    void set(Currency[] currencies);
}
