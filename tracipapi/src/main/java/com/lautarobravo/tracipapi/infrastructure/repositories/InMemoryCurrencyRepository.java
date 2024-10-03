package com.lautarobravo.tracipapi.infrastructure.repositories;


import com.lautarobravo.tracipapi.domain.model.Currency;
import com.lautarobravo.tracipapi.domain.model.Symbol;
import com.lautarobravo.tracipapi.domain.repositories.CurrencyRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class InMemoryCurrencyRepository implements CurrencyRepository {

    List<Currency> datas = new ArrayList<Currency>();

    @Override
    public boolean hasWith(Symbol symbol) {
        return datas.stream().anyMatch(d -> d.hasSameSymbol(symbol));
    }

    @Override
    public Currency get(Symbol symbol) {
        return datas.stream()
                .filter(d -> d.hasSameSymbol(symbol))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No currency found for " +symbol));
    }

    @Override
    public void set(Currency currency) {
        if(hasWith(currency.getSymbol()))
        {
            for (int i = 0; i < datas.size(); i++) {
                Currency currentCurrency = datas.get(i);
                if (currentCurrency.areTheSame(currency))
                    datas.set(i, currency);
            }
        }
        else
            datas.add(currency);
    }

    @Override
    public void set(Currency[] currencies) {
        this.datas = Arrays.stream(currencies).toList();
    }
}