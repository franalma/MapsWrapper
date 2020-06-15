package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;

import com.huawei.hms.maps.model.PatternItem;
import java.util.List;

public class CircleOptions {
    com.huawei.hms.maps.model.CircleOptions huawei;
    com.google.android.gms.maps.model.CircleOptions google;


    public CircleOptions(){
        google = new com.google.android.gms.maps.model.CircleOptions() ;
        huawei = new com.huawei.hms.maps.model.CircleOptions();
    }

    public CircleOptions center(LatLng latLng) {
        google.center(latLng.google);
        huawei.center(latLng.huawei);
        return this;
    }

    public CircleOptions clickable(boolean value) {
        google.clickable(value);
        huawei.clickable(value);
        return this;
    }

    public CircleOptions fillColor(int value) {
        google.fillColor(value);
        huawei.fillColor(value);
        return this;
    }

    public CircleOptions radius(double value) {
        if (google != null)  google.radius(value);
        if (huawei != null)  huawei.radius(value);
        return this;
    }

    public CircleOptions strokeColor(int value) {
        if (google != null)  google.strokeColor(value);
        if (huawei != null)  huawei.strokeColor(value);
        return this;
    }

    public CircleOptions strokePattern(List<PatternItem> var1) {
        //TODO
            return this;
    }

    public CircleOptions strokeWidth(float value) {
        if (google != null)  google.strokeWidth(value);
        if (huawei != null)  huawei.strokeWidth(value);
        return this;
    }

    public CircleOptions visible(boolean value) {
        if (google != null)  google.visible(value);
        if (huawei != null)  huawei.visible(value);
        return this;
    }

    public CircleOptions zIndex(float value) {
        if (google != null)  google.zIndex(value);
        if (huawei != null)  huawei.zIndex(value);
        return this;
    }

}
