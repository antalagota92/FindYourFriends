package com.example.aantal.findyourfriends;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap googleMap; // Might be null if Google Play services APK is not available.

    private String name;
    private LatLng friendLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        final Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.name = extras.getString("name");
        }

        getFriendLocation();
        handleMapInitialization();
    }

    @Override
    protected void onResume() {
        super.onResume();

        handleMapInitialization();
    }

    private void handleMapInitialization() {
        setUpMapIfNeeded();

        if (googleMap != null) {
            addSelectedFriendsLocationToMap(friendLocation);
        }
    }

    private void getFriendLocation() {
        Friend[] myFriends = FriendContainer.getFriends();

        for (int i=0; i < myFriends.length; i++) {
            if (myFriends[i].getName().equalsIgnoreCase(name)) {
                friendLocation = myFriends[i].getLatLng();
            }
        }
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (googleMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (googleMap != null) {
                googleMap.setMyLocationEnabled(true);
                googleMap.clear();
            }
        }
    }

    public void addSelectedFriendsLocationToMap(final LatLng coordinates) {
        googleMap.addMarker(new MarkerOptions()
                .position(coordinates)
                .title(name)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
    }

}

