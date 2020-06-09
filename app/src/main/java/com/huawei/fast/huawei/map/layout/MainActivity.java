package com.huawei.fast.huawei.map.layout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.google.android.gms.maps.GoogleMap;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper.ExtendedMap;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.MultipleSupportMapFragment;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.OnMapReadyCallback;
import com.huawei.hms.maps.HuaweiMap;



public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private String TAG = "MultipleSupportFragmentTest";
    MultipleSupportMapFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = (MultipleSupportMapFragment)
                this.getSupportFragmentManager().findFragmentById(R.id.id_framelayout_map);
        fragment.getMapAsync(this);

//        getSupportFragmentManager().beginTransaction().replace(R.id.id_framelayout_map, fragment).commit();
//        fragment.getMapAsync(this);
//        assert fragment != null;
//        fragment.getMapAsync(this);


        //getsupport
//        com.huawei.hms.maps.SupportMapFragment fragment =(com.huawei.hms.maps.SupportMapFragment)
//                getSupportFragmentManager().findFragmentById(R.id.id_framelayout_map);
//        fragment.getMapAsync(this);

    }

    public void loadHuaweiMap(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.id_multi_fragment,
                new com.huawei.hms.maps.SupportMapFragment() ).commit();
    }

    public void loadGoogleMap(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.id_multi_fragment,
                new com.google.android.gms.maps.SupportMapFragment() ).commit();
    }





    @Override
    public void onMapReady(ExtendedMap map) {
        Log.d(TAG, "onMapReady for Extended" + "Map");
        if (map.getGoogleMap() != null){
            GoogleMap googleMap = map.getGoogleMap();
            googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }else{
            HuaweiMap huaweiMap = map.getHuaweiMap();
//            huaweiMap.setMapType(HuaweiMap.MAP_TYPE_SATELLITE);
        }

    }
}
