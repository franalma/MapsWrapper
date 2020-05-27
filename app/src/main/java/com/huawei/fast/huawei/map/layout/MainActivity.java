package com.huawei.fast.huawei.map.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.MultipleSupportMapFragment;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.OnMapReadyCallback;
import com.huawei.hms.maps.HuaweiMap;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private String TAG = "MultipleSupportFragmentTest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MultipleSupportMapFragment fragment = (MultipleSupportMapFragment)
                this.getSupportFragmentManager().findFragmentById(R.id.id_framelayout_map);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG,"onMapReady GMS");
    }

    @Override
    public void onMapReady(HuaweiMap map) {
        Log.d(TAG,"onMapReady HMS");
    }
}
