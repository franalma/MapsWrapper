package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.GoogleMap;
import com.huawei.fast.huawei.map.hmsgmsmaplayout.R;
import com.huawei.hms.maps.HuaweiMap;


public class SupportMapFragment extends Fragment {
    private MapResolverStrategy mapResolverStrategy;
    private Fragment mapFragment;

    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public void getMapAsync(final OnMapReadyCallback callback){

        if (isGoogleMap()){
            System.out.println("---getting google map");
            final com.google.android.gms.maps.SupportMapFragment googleFragment = (com.google.android.gms.maps.SupportMapFragment)mapFragment;
            googleFragment.getMapAsync(new com.google.android.gms.maps.OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    callback.onMapReady(new ExtendedMap(googleMap));
                }
            });
        }
        else if (isHuaweiMap()){
            System.out.println("---getting huawei map");
            final com.huawei.hms.maps.SupportMapFragment fragment = (com.huawei.hms.maps.SupportMapFragment) mapFragment;
            System.out.println("---- fragment: "+fragment);
            fragment.getMapAsync(new com.huawei.hms.maps.OnMapReadyCallback() {
                @Override
                public void onMapReady(HuaweiMap huaweiMap) {
                    System.out.println("--on map ready support fragment");
                    callback.onMapReady(new ExtendedMap(huaweiMap));
                }
            });
        }
    }

    private boolean isGoogleMap(){
        return mapFragment instanceof com.google.android.gms.maps.SupportMapFragment;
    }

    private boolean isHuaweiMap(){
        return mapFragment instanceof com.huawei.hms.maps.SupportMapFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_container,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert getFragmentManager() != null;
        getFragmentManager().beginTransaction().replace(R.id.container, mapFragment).commit();
    }

    @Override
    public void onInflate(@NonNull Context context, @NonNull AttributeSet attrs, @Nullable Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.mapResolution);
        String type = array.getString(R.styleable.mapResolution_type);
        mapResolverStrategy = MapResolverStrategy.fromValue(type);
        try{
            mapFragment = MapResolverStrategy.useRequiredMapFragment(mapResolverStrategy, context);
        }catch(Exception e){
            e.printStackTrace();
        }
        array.recycle();
    }



}
