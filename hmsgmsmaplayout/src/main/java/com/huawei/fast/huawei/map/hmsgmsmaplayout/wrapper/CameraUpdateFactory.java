package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;

public class CameraUpdateFactory {

    public static CameraUpdate zoomIn(){
        com.google.android.gms.maps.CameraUpdate google = null;
        com.huawei.hms.maps.CameraUpdate huawei = null;
        try{
            google = com.google.android.gms.maps.CameraUpdateFactory.zoomIn();
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            huawei = com.huawei.hms.maps.CameraUpdateFactory.zoomIn();
        }catch(Exception e){
            e.printStackTrace();
        }
        return new CameraUpdate(huawei, google);
    }

    public static CameraUpdate zoomOut(){
        com.google.android.gms.maps.CameraUpdate google = null;
        com.huawei.hms.maps.CameraUpdate huawei = null;
        try{
            google = com.google.android.gms.maps.CameraUpdateFactory.zoomOut();
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            huawei = com.huawei.hms.maps.CameraUpdateFactory.zoomOut();
        }catch(Exception e){
            e.printStackTrace();
        }
        return new CameraUpdate(huawei, google);
    }


    public static CameraUpdate scrollBy(float x, float y){
        com.google.android.gms.maps.CameraUpdate google = null;
        com.huawei.hms.maps.CameraUpdate huawei = null;
        try{
            google = com.google.android.gms.maps.CameraUpdateFactory.scrollBy(x,y);
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            huawei = com.huawei.hms.maps.CameraUpdateFactory.scrollBy(x,y);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new CameraUpdate(huawei, google);
    }

    public static CameraUpdate zoomTo(float value){
        com.google.android.gms.maps.CameraUpdate google = null;
        com.huawei.hms.maps.CameraUpdate huawei = null;
        try{
            google = com.google.android.gms.maps.CameraUpdateFactory.zoomTo(value);
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            huawei = com.huawei.hms.maps.CameraUpdateFactory.zoomTo(value);
        }catch(Exception e){
            e.printStackTrace();
        }

        return new CameraUpdate(huawei, google);
    }

    public static CameraUpdate newLatLngZoom(LatLng position, float zoom){
        com.google.android.gms.maps.CameraUpdate google = null;
        com.huawei.hms.maps.CameraUpdate huawei = null;
        try{
             google = com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(position.google, zoom);
        }catch(Exception e){}

        try{
            huawei = com.huawei.hms.maps.CameraUpdateFactory.newLatLngZoom(position.huawei, zoom);
        }catch(Exception e){
            e.printStackTrace();
        }

        return new CameraUpdate(huawei, google);
    }

    public static CameraUpdate newCameraPosition(CameraPosition position){
        com.google.android.gms.maps.CameraUpdate google = null;
        com.huawei.hms.maps.CameraUpdate huawei = null;
        try{
            google = com.google.android.gms.maps.CameraUpdateFactory.newCameraPosition(position.google);
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            huawei = com.huawei.hms.maps.CameraUpdateFactory.newCameraPosition(position.huawei);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new CameraUpdate(huawei, google);
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds bounds, int value){
        com.google.android.gms.maps.CameraUpdate google = null;
        com.huawei.hms.maps.CameraUpdate huawei = null;
        try{
            google = com.google.android.gms.maps.CameraUpdateFactory.newLatLngBounds(bounds.google, value);
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            huawei = com.huawei.hms.maps.CameraUpdateFactory.newLatLngBounds(bounds.huawei, value);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new CameraUpdate(huawei, google);
    }

    public static CameraUpdate newLatLng(LatLng position){
        com.google.android.gms.maps.CameraUpdate google = null;
        com.huawei.hms.maps.CameraUpdate huawei = null;
        try{
            google = com.google.android.gms.maps.CameraUpdateFactory.newLatLng(position.google);
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            huawei = com.huawei.hms.maps.CameraUpdateFactory.newLatLng(position.huawei);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new CameraUpdate(huawei, google);
    }

}
