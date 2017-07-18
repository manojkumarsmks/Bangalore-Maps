package com.example.mkumar.bangaloremaps;

/**
 * Created by mkumar on 6/28/2017.
 */

public class MapElements {

    String  Name, Latitude, Longitude;

    public MapElements() {

    }

    public MapElements( String name, String latitude, String longitude) {
        this.Name = name;
        this.Latitude = latitude;
        this.Longitude = longitude;
    }

    public MapElements(String Name) {
        this.Name = Name;
    }




    public String getName() {
        return Name;
    }

    public String getLatitude() {
        return Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }


}
