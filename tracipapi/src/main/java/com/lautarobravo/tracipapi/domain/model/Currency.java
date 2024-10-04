package com.lautarobravo.tracipapi.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@NoArgsConstructor
public class Currency implements Serializable {

    @Id
    private Symbol symbol;
    private double valueInUsd;

    public Currency(Symbol symbol, double value) {
        this.symbol = symbol;
        this.valueInUsd = value;
    }

    public static Currency from(Symbol symbol, double gBP) {
        return new Currency(symbol, gBP);
    }

    @Override
    public String toString() {
        return symbol.toString() + " - ("+valueInUsd+" USD)";
    }

    public boolean hasSameSymbol(Symbol symbol) {
        return this.symbol.sameAs(symbol.getCode());
    }

    public String getSymbolCode() {
        return symbol.getCode();
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public boolean areTheSame(Currency currency) {
        return currency.getSymbolCode().equals(getSymbolCode());
    }
}

