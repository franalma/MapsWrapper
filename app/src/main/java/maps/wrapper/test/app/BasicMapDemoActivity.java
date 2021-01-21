package maps.wrapper.test.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import maps.wrapper.CameraUpdateFactory;
import maps.wrapper.ExtendedMap;
import maps.wrapper.LatLng;
import maps.wrapper.MarkerOptions;
import maps.wrapper.OnMapReadyCallback;
import maps.wrapper.SupportMapFragment;


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
