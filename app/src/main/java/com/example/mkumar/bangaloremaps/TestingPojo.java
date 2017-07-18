package com.example.mkumar.bangaloremaps;

/**
 * Created by mkumar on 7/18/2017.
 */

public class TestingPojo {


    String  Name;
    String Latitude;
    String Longitude;

    public TestingPojo() {

    }

    public TestingPojo( String Latitude) {
        this.Name = Latitude;
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
