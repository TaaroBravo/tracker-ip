package com.lautarobravo.tracipapi.infrastructure.repositories;

import com.lautarobravo.tracipapi.domain.repositories.CountryDataRepository;
import com.lautarobravo.tracipapi.infrastructure.dtos.countrydata.CountryData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryCountryDataRepository implements CountryDataRepository {

    List<CountryData> datas = new ArrayList<CountryData>();

    @Override
    public boolean hasWith(String code) {
        return datas.stream().anyMatch(d -> d.hasSameCode(code));
    }

    @Override
    public CountryData get(String code) {
        return datas.stream()
                .filter(d -> d.hasSameCode(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No country data found for " +code));
    }

    @Override
    public void add(CountryData data) {
        if(hasWith(data.getIsoCode()))
        {
            for (int i = 0; i < datas.size(); i++) {
                CountryData currency = datas.get(i);
                if (currency.hasSameCode(data.getIsoCode()))
                    datas.set(i, data);
            }
        }
        else
            datas.add(data);
    }

    @Override
    public void set(List<CountryData> datas) {
        this.datas = datas;
    }
}