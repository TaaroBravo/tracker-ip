package com.lautarobravo.tracipapi.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class Distance implements Serializable {
    @Id
    private String country;
    private double value;

    public Distance(String country, double value) {
        this.country = country;
        this.value = value;
    }

    public static Distance from(String country, CoordinatePosition from, CoordinatePosition to){
      return new Distance(country, distance(from.getLatitude(), from.getLongitude(), to.getLatitude(), to.getLongitude()));
    };

    public static Distance Average(double value) {
        return new Distance("Average", value);
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        return nf.format(value) + " Km.";
    }

    //Lauta: I understand that the purpose of this exercise is testing mathematical knowledge, so this function was taken from Stackoverflow and validated by users.
    private static double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        return dist;
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    public boolean isGreaterThan(Distance distance) {
        return value > distance.value;
    }

    public boolean sameAs(Distance distance) {
        return Objects.equals(distance.country, country);
    }

    public double getValue() {
        return value;
    }
}
