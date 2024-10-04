package com.lautarobravo.tracipapi.domain.repositories;

import com.lautarobravo.tracipapi.domain.model.Currency;
import com.lautarobravo.tracipapi.domain.model.Symbol;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Symbol> {

}
