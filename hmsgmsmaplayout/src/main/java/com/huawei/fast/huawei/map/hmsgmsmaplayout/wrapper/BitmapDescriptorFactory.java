package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;

import android.util.Log;

public class BitmapDescriptorFactory {
    public final static float  HUE_RED = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_RED;
    public final static float HUE_ORANGE = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_ORANGE;
    public final static float HUE_YELLOW = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_YELLOW;
    public final static float HUE_GREEN = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_GREEN;
    public final static float HUE_CYAN = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_CYAN;
    public final static float HUE_AZURE = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_AZURE;
    public final static float HUE_BLUE = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_BLUE;
    public final static float HUE_VIOLET = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_VIOLET;
    public final static float HUE_MAGENTA = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_MAGENTA;
    public final static float HUE_ROSE = com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_ROSE;

    public static BitmapDescriptor  fromResource (int id){
        com.google.android.gms.maps.model.BitmapDescriptor google = null;
        com.huawei.hms.maps.model.BitmapDescriptor huawei = null;
        try{
            google = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromResource(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            huawei = com.huawei.hms.maps.model.BitmapDescriptorFactory.fromResource(id);
        }catch(Exception e){

        }
        return new BitmapDescriptor(huawei,google);
    }

    public static BitmapDescriptor  defaultMarker (float hue){
        com.google.android.gms.maps.model.BitmapDescriptor google = null;
        com.huawei.hms.maps.model.BitmapDescriptor huawei = null;
        try{
            google = com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker(hue);
        }catch(Exception e){

        }
        try{
            huawei = com.huawei.hms.maps.model.BitmapDescriptorFactory.defaultMarker(hue);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new BitmapDescriptor(huawei,google);
    }
}
