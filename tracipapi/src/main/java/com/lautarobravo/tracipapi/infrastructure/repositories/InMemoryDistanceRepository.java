package com.lautarobravo.tracipapi.infrastructure.repositories;

import com.lautarobravo.tracipapi.domain.model.Distance;
import com.lautarobravo.tracipapi.domain.repositories.DistancesRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryDistanceRepository implements DistancesRepository {

    List<Distance> distances = new ArrayList<>();

    @Override
    public List<Distance> findAll() {
        return distances;
    }

    @Override
    public void save(Distance distance) {
        if(hasWith(distance))
        {
            for (int i = 0; i < distances.size(); i++) {
                Distance currentDistance = distances.get(i);
                if (currentDistance.sameAs(distance))
                    break;
            }
        }
        else
            distances.add(distance);
    }

    private boolean hasWith(Distance distance) {
        return distances.stream().anyMatch(d -> d.sameAs(distance));
    }

}
