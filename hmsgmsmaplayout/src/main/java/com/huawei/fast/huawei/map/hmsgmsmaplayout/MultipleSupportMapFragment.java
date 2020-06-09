package com.huawei.fast.huawei.map.hmsgmsmaplayout;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.GoogleMap;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper.ExtendedMap;
import com.huawei.hms.maps.HuaweiMap;


public class MultipleSupportMapFragment extends Fragment {
    private boolean isHms = true;


    public void getMapAsync(final OnMapReadyCallback callback){

        com.huawei.hms.maps.OnMapReadyCallback hCallback = new com.huawei.hms.maps.OnMapReadyCallback() {
            @Override
            public void onMapReady(HuaweiMap huaweiMap) {
                ExtendedMap extendedMap = new ExtendedMap(huaweiMap);
                callback.onMapReady(extendedMap);
            }
        };
        com.google.android.gms.maps.OnMapReadyCallback gCallback = new com.google.android.gms.maps.OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                ExtendedMap extendedMap = new ExtendedMap(googleMap);
                callback.onMapReady(extendedMap);
            }
        };

        assert getFragmentManager() != null;
        if (!isHms){
            com.google.android.gms.maps.SupportMapFragment fragment = new com.google.android.gms.maps.SupportMapFragment();
            fragment.getMapAsync(gCallback);
            getFragmentManager().beginTransaction().replace(R.id.id_multi_fragment, fragment).commit();
        }else{
            com.huawei.hms.maps.SupportMapFragment fragment = new com.huawei.hms.maps.SupportMapFragment();
            fragment.getMapAsync(hCallback);
            getFragmentManager().beginTransaction().replace(R.id.id_multi_fragment, fragment).commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_container,container,false);
    }
}
