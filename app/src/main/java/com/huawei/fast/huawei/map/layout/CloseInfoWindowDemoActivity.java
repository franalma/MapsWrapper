package com.huawei.fast.huawei.map.layout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper.CameraUpdateFactory;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper.ExtendedMap;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper.LatLng;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper.LatLngBounds;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper.Marker;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper.MarkerOptions;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper.SupportMapFragment;
import java.util.Arrays;
import java.util.List;

public class CloseInfoWindowDemoActivity extends AppCompatActivity implements OnMapAndViewReadyListener.OnGlobalLayoutAndMapReadyListener {

    ExtendedMap map;
    Marker selectedMarker;

    private ExtendedMap.OnMarkerClickListener markerClickListener = new ExtendedMap.OnMarkerClickListener() {
        @Override
        public boolean onMarkerClick(Marker marker) {
            if (marker == selectedMarker){
                selectedMarker = null;
                // Return true to indicate we have consumed the event and that we do not
                // want the the default behavior to occur (which is for the camera to move
                // such that the marker is centered and for the marker's info window to open,
                // if it has one).
                return true;
            }
            selectedMarker = marker;
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_close_info_window_demo);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        assert mapFragment != null;
        new OnMapAndViewReadyListener (mapFragment, this);

    }


    @Override
    public void onMapReady(ExtendedMap map) {
        this.map = map;
        this.map.getUiSettings().setZoomControlsEnabled(false);
        this.map.setOnMarkerClickListener(markerClickListener);
        this.map.setOnMapClickListener(null);
        this.map.setContentDescription(getString(R.string.close_info_window_demo_details));
        LatLngBounds.Builder bounds = new LatLngBounds.Builder();
        for (MarkerInfo city:cities){
            map.addMarker(new MarkerOptions()
                    .position(city.latLng)
                    .title(city.title)
                    .snippet(city.snippet)
            );
            bounds.include(city.latLng);
        }
        map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(),50));

    }


    private List<MarkerInfo> cities = Arrays.asList(
            new MarkerInfo(new LatLng(-27.47093, 153.0235), "Brisbane", "Population: 2,074,200"),
            new MarkerInfo(new LatLng(-37.81319, 144.96298), "Melbourne", "Population: 4,137,400"),
            new MarkerInfo(new LatLng(-33.87365, 151.20689), "Sydney", "Population: 4,627,300"),
            new MarkerInfo(new LatLng(-34.92873, 138.59995), "Adelaide", "Population: 1,213,000"),
            new MarkerInfo(new LatLng(-31.952854, 115.857342), "Perth", "Population: 1,738,800")
            );

    static class MarkerInfo{

        private LatLng latLng;
        private String title;
        private String snippet;

        public MarkerInfo(LatLng latLng, String title, String snippet) {
            this.latLng = latLng;
            this.title = title;
            this.snippet = snippet;
        }


    }



}
