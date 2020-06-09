package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;

import androidx.annotation.Nullable;
import com.huawei.hms.maps.model.PatternItem;
import java.util.List;

public class CircleOptions {
    private com.huawei.hms.maps.model.CircleOptions hmsCircleOptions;
    private com.google.android.gms.maps.model.CircleOptions gmsCircleOptions;
    public static boolean isHms = false;

    public CircleOptions(){
        if (!isHms){
            gmsCircleOptions = new com.google.android.gms.maps.model.CircleOptions() ;
        }else{
            hmsCircleOptions = new com.huawei.hms.maps.model.CircleOptions();
        }
    }

    com.huawei.hms.maps.model.CircleOptions getHmsCircleOptions() {
        return hmsCircleOptions;
    }

    com.google.android.gms.maps.model.CircleOptions getGmsCircleOptions() {
        return gmsCircleOptions;
    }

    public CircleOptions center(LatLng latLng) {
        if (gmsCircleOptions != null) gmsCircleOptions.center(new com.google.android.gms.maps.model.LatLng(latLng.getLat(), latLng.getLng()));
        if (hmsCircleOptions != null) hmsCircleOptions.center(new com.huawei.hms.maps.model.LatLng(latLng.getLat(), latLng.getLng()));
        return this;
    }

    public CircleOptions clickable(boolean value) {
        if (gmsCircleOptions != null) gmsCircleOptions.clickable(value);
        if (hmsCircleOptions != null) hmsCircleOptions.clickable(value);
        return this;
    }

    public CircleOptions fillColor(int value) {
        if (gmsCircleOptions != null) gmsCircleOptions.fillColor(value);
        if (hmsCircleOptions != null) hmsCircleOptions.fillColor(value);
        return this;
    }

    public LatLng getCenter() {
        LatLng latLng = null;
        if (gmsCircleOptions != null) {
            latLng = new LatLng(gmsCircleOptions.getCenter().latitude, gmsCircleOptions.getCenter().longitude);
        }
        if (hmsCircleOptions != null) {
            latLng = new LatLng(hmsCircleOptions.getCenter().latitude, hmsCircleOptions.getCenter().longitude);
        }
        return latLng;
    }

    public int getFillColor(){
        if (gmsCircleOptions != null) return gmsCircleOptions.getFillColor();
        if (hmsCircleOptions != null) return hmsCircleOptions.getFillColor();
        return -1;
    }

    public double getRadius() {
        if (gmsCircleOptions != null) return gmsCircleOptions.getRadius();
        if (hmsCircleOptions != null) return hmsCircleOptions.getRadius();
        return -1;
    }

    public int getStrokeColor() {
        if (gmsCircleOptions != null) return gmsCircleOptions.getStrokeColor();
        if (hmsCircleOptions != null) return hmsCircleOptions.getStrokeColor();
        return -1;
    }

    @Nullable
    public List<PatternItem> getStrokePattern() {
        //TODO
        return null;
    }

    public float getStrokeWidth() {
        if (gmsCircleOptions != null) return gmsCircleOptions.getStrokeWidth();
        if (hmsCircleOptions != null) return hmsCircleOptions.getStrokeWidth();
        return -1;

    }

    public float getZIndex() {
        if (gmsCircleOptions != null) return gmsCircleOptions.getZIndex();
        if (hmsCircleOptions != null) return hmsCircleOptions.getZIndex();
        return -1;
    }

    public boolean isClickable() {
        if (gmsCircleOptions != null) return gmsCircleOptions.isClickable();
        if (hmsCircleOptions != null) return hmsCircleOptions.isClickable();
        return false;
    }

    public boolean isVisible() {
        if (gmsCircleOptions != null) return gmsCircleOptions.isVisible();
        if (hmsCircleOptions != null) return hmsCircleOptions.isVisible();
        return false;
    }

    public CircleOptions radius(double value) {
        if (gmsCircleOptions != null)  gmsCircleOptions.radius(value);
        if (hmsCircleOptions != null)  hmsCircleOptions.radius(value);
        return this;
    }

    public CircleOptions strokeColor(int value) {
        if (gmsCircleOptions != null)  gmsCircleOptions.strokeColor(value);
        if (hmsCircleOptions != null)  hmsCircleOptions.strokeColor(value);
        return this;
    }

    public CircleOptions strokePattern(List<PatternItem> var1) {
        //TODO
            return this;
    }

    public CircleOptions strokeWidth(float value) {
        if (gmsCircleOptions != null)  gmsCircleOptions.strokeWidth(value);
        if (hmsCircleOptions != null)  hmsCircleOptions.strokeWidth(value);
        return this;
    }

    public CircleOptions visible(boolean value) {
        if (gmsCircleOptions != null)  gmsCircleOptions.visible(value);
        if (hmsCircleOptions != null)  hmsCircleOptions.visible(value);
        return this;
    }

    public CircleOptions zIndex(float value) {
        if (gmsCircleOptions != null)  gmsCircleOptions.zIndex(value);
        if (hmsCircleOptions != null)  hmsCircleOptions.zIndex(value);
        return this;
    }

    public com.huawei.hms.maps.model.CircleOptions toHms(){
        com.huawei.hms.maps.model.CircleOptions options = new com.huawei.hms.maps.model.CircleOptions();
        options.center(new com.huawei.hms.maps.model.LatLng(this.getCenter().getLat(),this.getCenter().getLng()));

        return options;
    }



    public com.google.android.gms.maps.model.CircleOptions toGms(){
        com.google.android.gms.maps.model.CircleOptions options = new com.google.android.gms.maps.model.CircleOptions();
        options.center(new com.google.android.gms.maps.model.LatLng(this.getCenter().getLat(), this.getCenter().getLng()));
        return options;
    }



}
