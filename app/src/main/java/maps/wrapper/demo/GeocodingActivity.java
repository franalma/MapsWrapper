package maps.wrapper.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import maps.wrapper.CameraUpdate;
import maps.wrapper.CameraUpdateFactory;
import maps.wrapper.ExtendedMap;
import maps.wrapper.LatLng;
import maps.wrapper.MarkerOptions;
import maps.wrapper.OnMapReadyCallback;
import maps.wrapper.SupportMapFragment;

import java.util.List;

public class GeocodingActivity extends AppCompatActivity {

    private ExtendedMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geocoding);

        SupportMapFragment fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        assert fragment != null;
        fragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(ExtendedMap map) {
                GeocodingActivity.this.map = map;
            }
        });
        final EditText editText = findViewById(R.id.query);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    map.clear();
                    moveToAddress(editText.getText().toString());
                    editText.getText().clear();
                    return true;
                }
                return false;
            }
        });
    }

    private void moveToAddress(String address){
        if (!Geocoder.isPresent()){
            toast(R.string.no_geocoder);
            return;
        }
        try{
            List<Address> list = new Geocoder(this).getFromLocationName(address,1);
            assert list != null && list.size()>0;
            Address info = this.setMarker(list.get(0));
            info = this.centerCamera(info);

        }catch(Exception e){
            e.printStackTrace();
            toast(R.string.error);
        }
    }
    private void toast(int id){
        Toast.makeText(this, id, Toast.LENGTH_LONG).show();
    }

    private Address setMarker(Address address){
        LatLng position = new LatLng(address.getLatitude(), address.getLongitude());
        MarkerOptions marker = new MarkerOptions().position(position);
        map.addMarker(marker);
        return address;
    }

    private Address centerCamera(Address address){
        LatLng position = new LatLng(address.getLatitude(), address.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(position);
        map.moveCamera(cameraUpdate);
        return address;
    }
}
