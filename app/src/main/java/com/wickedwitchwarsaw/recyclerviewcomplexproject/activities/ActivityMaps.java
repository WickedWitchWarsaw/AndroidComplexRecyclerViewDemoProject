package com.wickedwitchwarsaw.recyclerviewcomplexproject.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.RushEvent;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZuZ on 2016-10-17.
 */
public class ActivityMaps extends BaseActivity {
    @BindView(R.id.activity_map_rush_name)
    protected TextView mapName;
    @BindView(R.id.activity_map_rush_date)
    protected TextView mapDate;
    @BindView(R.id.activity_map_rush_time)
    protected TextView mapTime;
    @BindView(R.id.activity_map_rush_description)
    protected TextView mapDescription;
    @BindView(R.id.activity_map_rush_address)
    protected TextView mapLocation;

    private GoogleApiClient mClient;
    private GoogleMap mMap;
    private RushEvent rushEvent;
    public static final String RUSH_EVENT_INFO = "RUSH_EVENT_INFO";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);

        rushEvent = getIntent().getParcelableExtra(RUSH_EVENT_INFO);

        mapName.setText(rushEvent.getEventName());
        mapDate.setText(rushEvent.getEventDate());
        mapTime.setText(rushEvent.getEventTime());
        mapLocation.setText(rushEvent.getEventLocation());
        mapDescription.setText(rushEvent.getEventDescription());


        mClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(@Nullable Bundle bundle) {
                        updateUI();
                    }

                    @Override
                    public void onConnectionSuspended(int i) {

                    }
                }).build();

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.activity_map_map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mClient.connect();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mClient.disconnect();
    }


    private void updateUI(){
        LatLng rushEventPoint = new LatLng(
               rushEvent.getEventLatitude(),
               rushEvent.getEventLongitude()
        );
        MarkerOptions rushEventMarker = new MarkerOptions()
                .position(rushEventPoint)
                .title("Event Location...")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

        mMap.clear();
        mMap.addMarker(rushEventMarker);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rushEventPoint, 16));
    }


    public static Intent newIntent(Context context, RushEvent rushEvent){
        Intent intent = new Intent(context, ActivityMaps.class);
        intent.putExtra(RUSH_EVENT_INFO, rushEvent);
        return intent;
    }
}
