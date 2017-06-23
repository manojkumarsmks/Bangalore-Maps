package com.example.mkumar.bangaloremaps;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private boolean mapReady;
    private static String TAG = MapsActivity.class.getSimpleName();
    private ImageButton filterButton;
    private FloatingActionButton newElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        newElement = (FloatingActionButton)findViewById(R.id.fab);
        newElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapsActivity.this, AddNewElements.class);
                startActivity(intent);
            }
        });
/*        final MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(MapsActivity.this);*/



    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng Bangalore = new LatLng(12.972442, 77.580643);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(Bangalore)
                .zoom(17)
                .bearing(90)
                .tilt(30)
                .build();
        mMap.addMarker(new MarkerOptions().position(Bangalore).title("Marker in Bangalore"));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
