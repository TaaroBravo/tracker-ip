package com.lautarobravo.tracipapi.infrastructure.responses.geolocalization;

public class CoordinatePositionResponse{
    public double latitude;
    public double longitude;

    public CoordinatePositionResponse(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static CoordinatePositionResponse from(double latitude, double longitude) {
        return new CoordinatePositionResponse(latitude, longitude);
    }

}
