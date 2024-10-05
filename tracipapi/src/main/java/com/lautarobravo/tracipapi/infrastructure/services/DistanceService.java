package com.lautarobravo.tracipapi.infrastructure.services;

import com.lautarobravo.tracipapi.domain.model.Distance;
import com.lautarobravo.tracipapi.infrastructure.repositories.DistancesRepository;
import com.lautarobravo.tracipapi.domain.services.IterableExtensions;
import com.lautarobravo.tracipapi.infrastructure.dtos.DistanceDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DistanceService {

    private final DistancesRepository distancesRepository;

    public DistanceService(DistancesRepository distancesRepository) {
        this.distancesRepository = distancesRepository;
    }

    public Distance getMaxDistance() {
        List<Distance> distances = getDistances();
        distances.sort(sortByGreatest());
        return distances.get(0);
    }

    public Distance getMinDistance() {
        List<Distance> distances = getDistances();
        distances.sort(sortByGreatest());
        return distances.get(distances.size() - 1);
    }

    public Distance getAverageDistance() {
        List<Distance> distances = getDistances();
        double allDistancesSum = 0;
        for (Distance distance : distances)
        {
            allDistancesSum+= distance.getValue();
        }
        return Distance.Average(allDistancesSum / distances.size());
    }

    private @NotNull ArrayList<Distance> getDistances() {
        return new ArrayList<>(IterableExtensions.toList(distancesRepository.findAll()).stream().map(DistanceDTO::toModel).toList());
    }

    public void save(Distance distance){
        distancesRepository.save(DistanceDTO.from(distance));
    }

    private static @NotNull Comparator<Distance> sortByGreatest() {
        return new Comparator<Distance>() {
            @Override
            public int compare(Distance o1, Distance o2) {
                if (o1.isGreaterThan(o2))
                    return -1;
                if (o2.isGreaterThan(o1))
                    return 1;
                return 0;
            }
        };
    }



}
