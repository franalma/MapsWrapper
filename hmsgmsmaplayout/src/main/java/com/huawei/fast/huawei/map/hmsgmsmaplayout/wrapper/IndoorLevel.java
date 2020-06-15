package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;

public class IndoorLevel {
    com.google.android.gms.maps.model.IndoorLevel google;
    com.huawei.hms.maps.model.IndoorLevel huawei;

    public IndoorLevel(com.google.android.gms.maps.model.IndoorLevel google, com.huawei.hms.maps.model.IndoorLevel huawei) {
        this.google = google;
        this.huawei = huawei;
    }

    public String getName() {
        if (google != null) return google.getName();
        if (huawei != null) return huawei.getName();
        return null;
    }


    public String getShortName() {
        if (google != null) return google.getShortName();
        if (huawei != null) return huawei.getShortName();
        return null;
    }

    public  void activate() {
        if (google != null)  google.activate();
        if (huawei != null)  huawei.activate();
    }


}
