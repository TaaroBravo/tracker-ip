package com.lautarobravo.tracipapi.infrastructure.dtos;

import com.lautarobravo.tracipapi.domain.model.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class CurrencyDTO {
    @Id
    private String code;
    private String name;
    private String symbol;
    private double value;

    public CurrencyDTO(String code, String name, String symbol, double value) {

        this.code = code;
        this.name = name;
        this.symbol = symbol;
        this.value = value;
    }

    public static CurrencyDTO from(Currency currency){
        return new CurrencyDTO(currency.getSymbolCode(),
                currency.getSymbolName(),
                currency.getCurrencySymbol(),
                currency.getValue());
    }

    public Currency toModel(){

        return new Currency(new Symbol(code, name, symbol), value);
    }
}
