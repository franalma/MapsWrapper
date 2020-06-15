package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;

public class LatLng {
 com.huawei.hms.maps.model.LatLng huawei;
 com.google.android.gms.maps.model.LatLng google;

    public double latitude;
    public double longitude;
    public LatLng(double latitude, double longitude) {
        this.huawei = new com.huawei.hms.maps.model.LatLng(latitude, longitude);
        this.google = new com.google.android.gms.maps.model.LatLng(latitude, longitude);
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
