package com.example.mkumar.bangaloremaps;

/**
 * Created by mkumar on 6/28/2017.
 */

public class MapElements {

    String  Name;
    double Latitude, Longitude;

    public MapElements() {

    }

    public MapElements( String name, double latitude, double longitude) {
        this.Name = name;
        this.Latitude = latitude;
        this.Longitude = longitude;
    }


    public String getName() {
        return Name;
    }

    public double getLatitude() {
        return Latitude;
    }

    public double getLongitude() {
        return Longitude;
    }


}
