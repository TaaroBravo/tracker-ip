package com.lautarobravo.tracipapi.infrastructure.dtos;

import com.lautarobravo.tracipapi.domain.model.Distance;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class DistanceDTO {
    @Id
    private String country;
    private double value;

    public DistanceDTO(String country, double value) {

        this.country = country;
        this.value = value;
    }

    public static DistanceDTO from(Distance distance){
        return new DistanceDTO(distance.getCountry(), distance.getValue());
    }

    public Distance toModel(){

        return new Distance(country, value);
    }
}
