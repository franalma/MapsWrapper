package com.huawei.fast.huawei.map.hmsgmsmaplayout.wrapper;


import com.google.android.gms.maps.GoogleMap;
import com.huawei.hms.maps.HuaweiMap;

public class UiSettings {

    private HuaweiMap huaweiMap;
    private GoogleMap googleMap;

    public UiSettings(HuaweiMap huaweiMap) {
        this.huaweiMap = huaweiMap;
    }

    public UiSettings(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    public final void setZoomControlsEnabled(boolean value) {
        if (huaweiMap != null) huaweiMap.getUiSettings().setZoomControlsEnabled(value);
        if (googleMap != null) googleMap.getUiSettings().setZoomControlsEnabled(value);
    }
    

    public final void setCompassEnabled(boolean value) {
        if (huaweiMap != null) huaweiMap.getUiSettings().setCompassEnabled(value);
        if (googleMap != null) googleMap.getUiSettings().setCompassEnabled(value);
    }

    public final void setMyLocationButtonEnabled(boolean value) {
        if (huaweiMap != null) huaweiMap.getUiSettings().setMyLocationButtonEnabled(value);
        if (googleMap != null) googleMap.getUiSettings().setMyLocationButtonEnabled(value);
    }

    public final void setIndoorLevelPickerEnabled(boolean value) {
        if (huaweiMap != null) huaweiMap.getUiSettings().setIndoorLevelPickerEnabled(value);
        if (googleMap != null) googleMap.getUiSettings().setIndoorLevelPickerEnabled(value);
    }

    public final void setScrollGesturesEnabled(boolean value) {
        if (huaweiMap != null) huaweiMap.getUiSettings().setScrollGesturesEnabled(value);
        if (googleMap != null) googleMap.getUiSettings().setScrollGesturesEnabled(value);
    }

    public final void setZoomGesturesEnabled(boolean value) {
        if (huaweiMap != null) huaweiMap.getUiSettings().setZoomGesturesEnabled(value);
        if (googleMap != null) googleMap.getUiSettings().setZoomGesturesEnabled(value);
    }

    public final void setTiltGesturesEnabled(boolean value) {
        if (huaweiMap != null) huaweiMap.getUiSettings().setTiltGesturesEnabled(value);
        if (googleMap != null) googleMap.getUiSettings().setTiltGesturesEnabled(value);
    }

    public final void setRotateGesturesEnabled(boolean value) {
        if (huaweiMap != null) huaweiMap.getUiSettings().setRotateGesturesEnabled(value);
        if (googleMap != null) googleMap.getUiSettings().setRotateGesturesEnabled(value);
    }

    public final void setScrollGesturesEnabledDuringRotateOrZoom(boolean value) {
        if (huaweiMap != null) huaweiMap.getUiSettings().setScrollGesturesEnabledDuringRotateOrZoom(value);
        if (googleMap != null) googleMap.getUiSettings().setScrollGesturesEnabledDuringRotateOrZoom(value);
    }

    public final void setAllGesturesEnabled(boolean value) {
        if (huaweiMap != null) huaweiMap.getUiSettings().setAllGesturesEnabled(value);
        if (googleMap != null) googleMap.getUiSettings().setAllGesturesEnabled(value);
    }

    public final void setMapToolbarEnabled(boolean value) {
        if (huaweiMap != null) huaweiMap.getUiSettings().setMapToolbarEnabled(value);
        if (googleMap != null) googleMap.getUiSettings().setMapToolbarEnabled(value);
    }

    public final boolean isZoomControlsEnabled() {
        if (huaweiMap != null) return huaweiMap.getUiSettings().isZoomControlsEnabled();
        if (googleMap != null) return googleMap.getUiSettings().isZoomControlsEnabled();
        return false;
    }

    public final boolean isCompassEnabled() {
        if (huaweiMap != null) return huaweiMap.getUiSettings().isCompassEnabled();
        if (googleMap != null) return googleMap.getUiSettings().isCompassEnabled();
        return false;
    }

    public final boolean isMyLocationButtonEnabled() {
        if (huaweiMap != null) return huaweiMap.getUiSettings().isMyLocationButtonEnabled();
        if (googleMap != null) return googleMap.getUiSettings().isMyLocationButtonEnabled();
        return false;
    }

    public final boolean isIndoorLevelPickerEnabled() {
        if (huaweiMap != null) return huaweiMap.getUiSettings().isIndoorLevelPickerEnabled();
        if (googleMap != null) return googleMap.getUiSettings().isIndoorLevelPickerEnabled();
        return false;
    }

    public final boolean isScrollGesturesEnabled() {
        if (huaweiMap != null) return huaweiMap.getUiSettings().isScrollGesturesEnabled();
        if (googleMap != null) return googleMap.getUiSettings().isScrollGesturesEnabled();
        return false;
    }

    public final boolean isScrollGesturesEnabledDuringRotateOrZoom() {
        if (huaweiMap != null) return huaweiMap.getUiSettings().isScrollGesturesEnabledDuringRotateOrZoom();
        if (googleMap != null) return googleMap.getUiSettings().isScrollGesturesEnabledDuringRotateOrZoom();
        return false;
    }

    public final boolean isZoomGesturesEnabled() {
        if (huaweiMap != null) return huaweiMap.getUiSettings().isZoomGesturesEnabled();
        if (googleMap != null) return googleMap.getUiSettings().isZoomGesturesEnabled();
        return false;
    }

    public final boolean isTiltGesturesEnabled() {
        if (huaweiMap != null) return huaweiMap.getUiSettings().isTiltGesturesEnabled();
        if (googleMap != null) return googleMap.getUiSettings().isTiltGesturesEnabled();
        return false;
    }

    public final boolean isRotateGesturesEnabled() {
        if (huaweiMap != null) return huaweiMap.getUiSettings().isRotateGesturesEnabled();
        if (googleMap != null) return googleMap.getUiSettings().isRotateGesturesEnabled();
        return false;
    }

    public final boolean isMapToolbarEnabled() {
        if (huaweiMap != null) return huaweiMap.getUiSettings().isMapToolbarEnabled();
        if (googleMap != null) return googleMap.getUiSettings().isMapToolbarEnabled();
        return false;
    }
}
