package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;

public class Cap {
    com.google.android.gms.maps.model.Cap gCap;
    com.huawei.hms.maps.model.Cap hCap;

    public Cap(com.google.android.gms.maps.model.Cap google, com.huawei.hms.maps.model.Cap huawei) {
        this.gCap = google;
        this.hCap = huawei;
    }

}
