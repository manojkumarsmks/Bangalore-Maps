package com.example.mkumar.bangaloremaps;

/**
 * Created by mkumar on 6/28/2017.
 */

public class MapElements {

    String  name, latitude, longitude;

    public MapElements() {

    }

    public MapElements( String name, String latitude, String longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }


}
