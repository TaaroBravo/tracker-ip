package com.lautarobravo.tracipapi.infrastructure.repositories;

import com.lautarobravo.tracipapi.domain.repositories.GeoLocalizationRepository;
import com.lautarobravo.tracipapi.infrastructure.dtos.geolocalization.GeoLocalizationData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InMemoryGeoLocalizationRepository implements GeoLocalizationRepository {

    List<GeoLocalizationData> datas = new ArrayList<GeoLocalizationData>();

    @Override
    public boolean hasWith(String ip) {
        return datas.stream().anyMatch(d -> d.hasIp(ip));
    }

    @Override
    public GeoLocalizationData get(String ip) {
        return datas.stream()
                .filter(d -> d.hasIp(ip))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No GeoLocalization found for " + ip));
    }

    @Override
    public void set(GeoLocalizationData data) {
        if(hasWith(data.getIp()))
        {
            for (int i = 0; i < datas.size(); i++) {
                GeoLocalizationData geoData = datas.get(i);
                if (geoData.hasIp(data.getIp()))
                    datas.set(i, data);
            }
        }
        else
            datas.add(data);
    }

    @Override
    public void set(GeoLocalizationData[] datas) {
        this.datas = Arrays.stream(datas).toList();
    }
}
