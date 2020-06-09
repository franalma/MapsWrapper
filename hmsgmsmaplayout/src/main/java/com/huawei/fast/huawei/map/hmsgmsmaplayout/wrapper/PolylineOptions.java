package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.huawei.hms.maps.model.Cap;
import com.huawei.hms.maps.model.PatternItem;

import java.util.ArrayList;
import java.util.List;

public class PolylineOptions {
    public static boolean isHms = false;
    com.huawei.hms.maps.model.PolylineOptions hOptions;
    com.google.android.gms.maps.model.PolylineOptions gOptions;

    public PolylineOptions(){
        if (isHms){
            hOptions = new com.huawei.hms.maps.model.PolylineOptions();
        }
        if (!isHms){
            gOptions = new com.google.android.gms.maps.model.PolylineOptions();
        }
    }

    public  PolylineOptions add(LatLng... values) {
        if (hOptions != null){
           com.huawei.hms.maps.model.LatLng [] list = new com.huawei.hms.maps.model.LatLng[values.length];
            for (int i = 0;i<values.length;i++){
                list[i] = (new com.huawei.hms.maps.model.LatLng(values[i].getLat(), values[i].getLng()));
            }
            hOptions.add(list);
        }

        if (gOptions != null){
            com.google.android.gms.maps.model.LatLng[] list = new com.google.android.gms.maps.model.LatLng[values.length];
            for (int i = 0;i<values.length;i++){
                list[i] = (new com.google.android.gms.maps.model.LatLng(values[i].getLat(), values[i].getLng()));
            }
            gOptions.add(list);
        }
        return this;
    }

    public PolylineOptions add(LatLng value) {
        if (hOptions != null) hOptions.add(new com.huawei.hms.maps.model.LatLng(value.getLat(), value.getLng()));
        if (gOptions != null) gOptions.add(new com.google.android.gms.maps.model.LatLng(value.getLat(), value.getLng()));
        return this;
    }

    //TODO
//    public PolylineOptions addAll(Iterable<LatLng> value) {
//
//    }

    public PolylineOptions clickable(boolean value) {
        if (isHms) hOptions.clickable(value);
        if (!isHms) gOptions.clickable(value);
        return this;
    }

    public PolylineOptions color(int value) {
        if (hOptions  != null) hOptions.color(value);
        if (gOptions != null) gOptions.color(value);
        return this;
    }

//TODO
//    public PolylineOptions endCap(Cap value) {
//        if (isHms) hOptions.endCap(value);
//        if (!isHms) gOptions.endCap(value);
//        return this;
//    }

    public PolylineOptions geodesic(boolean value) {
        if (hOptions != null) hOptions.geodesic(value);
        if (gOptions != null) gOptions.geodesic(value);
        return this;
    }

    public int getColor() {
        if (hOptions != null) return hOptions.getColor();
        if (gOptions != null) return gOptions.getColor();
        return -1;
    }

    //TODO
//    @NonNull
//    public Cap getEndCap() {
//        if (hOptions != null) return hOptions.getEndCap();
//        if (gOptions != null) return gOptions.getEndCap();
//
//    }

    public int getJointType() {
        if (hOptions != null) return hOptions.getJointType();
        if (gOptions != null) return gOptions.getJointType();
        return -1;
    }

    //TODO
//    @Nullable
//    public List<PatternItem> getPattern() {
//
//    }

    public List<LatLng> getPoints() {

    }

    @NonNull
    public Cap getStartCap() {

    }

    public float getWidth() {

    }

    public float getZIndex() {

    }

    public boolean isClickable() {

    }

    public boolean isGeodesic() {


    }

    public boolean isVisible() {
    }

    public PolylineOptions jointType(int value) {

    }

    public PolylineOptions pattern(List<PatternItem> var1) {

    }


    public PolylineOptions startCap(Cap value) {

    }

    public PolylineOptions visible(boolean value) {

    }

    public PolylineOptions width(float value) {

    }

    public PolylineOptions zIndex(float value) {

    }
}
