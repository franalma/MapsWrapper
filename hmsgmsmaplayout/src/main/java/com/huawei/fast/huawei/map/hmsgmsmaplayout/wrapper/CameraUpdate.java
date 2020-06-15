package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;

public class CameraUpdate {
    com.huawei.hms.maps.CameraUpdate huawei;
    com.google.android.gms.maps.CameraUpdate google;

    public CameraUpdate(com.huawei.hms.maps.CameraUpdate huawei, com.google.android.gms.maps.CameraUpdate google) {
        this.huawei = huawei;
        this.google = google;
    }
}
