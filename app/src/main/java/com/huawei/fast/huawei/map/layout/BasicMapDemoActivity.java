package com.huawei.fast.huawei.map.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper.CameraUpdateFactory;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper.ExtendedMap;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper.LatLng;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper.MarkerOptions;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper.OnMapReadyCallback;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper.SupportMapFragment;

public class BasicMapDemoActivity extends AppCompatActivity implements OnMapReadyCallback {
    private SupportMapFragment fragment;
    private LatLng sydney = new LatLng(-33.862, 151.21);
    private float zoomLevel = 13f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_map_demo);
        fragment = (SupportMapFragment)
                this.getSupportFragmentManager().findFragmentById(R.id.id_framelayout_map);
        assert  fragment != null;
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(ExtendedMap map) {
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel));
        map.addMarker(new MarkerOptions().position(sydney));
    }
}
