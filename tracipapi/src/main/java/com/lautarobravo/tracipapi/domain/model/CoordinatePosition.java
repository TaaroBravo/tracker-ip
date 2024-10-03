package com.lautarobravo.tracipapi.domain.model;

import java.text.NumberFormat;

public class CoordinatePosition {
    private double latitude;
    private double longitude;

    public CoordinatePosition(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static CoordinatePosition from(double latitude, double longitude) {
        return new CoordinatePosition(latitude, longitude);
    }

    @Override
    public String toString() {
        return "(latitude: " + transformToString(latitude) + " longitude:" + transformToString(longitude) + ")";
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude(){
        return latitude;
    }

    private String transformToString(double value){
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        return nf.format(value);
    }
}
