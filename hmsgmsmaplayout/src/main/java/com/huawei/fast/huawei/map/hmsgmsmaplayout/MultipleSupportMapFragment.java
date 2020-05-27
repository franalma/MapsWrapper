package com.huawei.fast.huawei.map.hmsgmsmaplayout;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.google.android.gms.maps.GoogleMap;
import com.huawei.hms.maps.HuaweiMap;

public class MultipleSupportMapFragment extends Fragment {

    boolean isHms = false;
    View currentView;
    private String TAG = "MultipleSupportFragment";
    private void print(String msg){
        Log.d(TAG, msg);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        print("OnCreateView");
        int id = R.layout.fragment_hms;
        if(!isHms){
            Log.d(TAG, "-----Inflating GMS");
            id = R.layout.fragment_gms;
        }
        System.out.println("----container: "+container);
        View view = inflater.inflate(id, container, false);
        System.out.println("-----view inflated: "+view);
        currentView = view;
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        print ("OnViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    public void getMapAsync(final OnMapReadyCallback callback){

        print("getMapAsync");
        com.huawei.hms.maps.OnMapReadyCallback hCallback = new com.huawei.hms.maps.OnMapReadyCallback() {
            @Override
            public void onMapReady(HuaweiMap huaweiMap) {
                callback.onMapReady(huaweiMap);
            }
        };
        com.google.android.gms.maps.OnMapReadyCallback gCallback = new com.google.android.gms.maps.OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                callback.onMapReady(googleMap);
            }
        };

        assert getFragmentManager() != null;
        if (isHms){
            com.huawei.hms.maps.SupportMapFragment supportMapFragmentHms =
                    (com.huawei.hms.maps.SupportMapFragment)(getActivity().getSupportFragmentManager().findFragmentById(R.id.map_hms));
            assert supportMapFragmentHms != null;
            supportMapFragmentHms.getMapAsync(hCallback);

        }else {
//            Fragment fragment = getView().getContext()getFragmentManager().findFragmentById(R.id.map_gms);
            FrameLayout frameLayout = currentView.findViewById(R.id.map_gms);
            Fragment fragment = frameLayout;
            com.google.android.gms.maps.SupportMapFragment supportMapFragmentGms  = new
                    com.google.android.gms.maps.SupportMapFragment();
            frameLayout.get
//            com.google.android.gms.maps.SupportMapFragment supportMapFragmentGms =
//                    (com.google.android.gms.maps.SupportMapFragment)(currentView.findViewById(R.id.map_gms));
//
//            if(supportMapFragmentGms != null){
//                System.out.println("-----supportMapFragmentGms:"+supportMapFragmentGms);
//                supportMapFragmentGms.getMapAsync(gCallback);
//            };


        }
    }

}
