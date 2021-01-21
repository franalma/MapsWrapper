package maps.wrapper;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Marker {
    com.google.android.gms.maps.model.Marker google;
    com.huawei.hms.maps.model.Marker huawei;

    Marker(com.google.android.gms.maps.model.Marker google, com.huawei.hms.maps.model.Marker huawei) {
        this.google = google;
        this.huawei = huawei;
    }

    public void setPosition(@NonNull LatLng latLng) {
        if (google != null) google.setPosition(latLng.google);
        if (huawei != null) huawei.setPosition(latLng.huawei);
    }

    public LatLng getPosition() {
        LatLng latLng = null;
        if (google != null)
            latLng = new LatLng(google.getPosition().latitude, google.getPosition().longitude);
        if (huawei != null)
            latLng = new LatLng(huawei.getPosition().latitude, huawei.getPosition().longitude);
        return latLng;
    }

    public void setIcon(@Nullable BitmapDescriptor value) {
        if (google != null) google.setIcon(value.google);
        if (huawei != null) huawei.setIcon(value.huawei);
    }

    public void setAnchor(float x, float y) {
        if (google != null) google.setAnchor(x, y);
        if (huawei != null) huawei.setMarkerAnchor(x, y);
    }

    public void setTitle(@Nullable String value) {
        if (google != null) google.setTitle(value);
        if (huawei != null) huawei.setTitle(value);
    }

    public String getTitle() {
        if (google != null) return google.getTitle();
        if (huawei != null) return huawei.getTitle();
        return null;
    }

    public void setSnippet(@Nullable String value) {
        if (google != null) google.setSnippet(value);
        if (huawei != null) huawei.setSnippet(value);
    }

    public String getSnippet() {
        String res = null;
        if (google != null) res = google.getSnippet();
        if (huawei != null) res = huawei.getSnippet();
        return res;
    }

    public boolean isInfoWindowShown() {
        boolean res = false;
        if (google != null) res = google.isInfoWindowShown();
        if (huawei != null) res = huawei.isInfoWindowShown();
        return res;
    }

    public void setFlat(boolean value) {
        if (google != null) google.setFlat(value);
        if (huawei != null) huawei.setFlat(value);
    }

    public boolean isFlat() {
        boolean res = false;
        if (google != null) res = google.isFlat();
        if (huawei != null) res = huawei.isFlat();
        return res;
    }

    public void setRotation(float value) {
        if (google != null) google.setRotation(value);
        if (huawei != null) huawei.setRotation(value);
    }

    public float getRotation() {
        float res = -1;
        if (google != null) res = google.getRotation();
        if (huawei != null) res = huawei.getRotation();
        return res;
    }

    public void setZIndex(float value) {
        if (google != null) google.setZIndex(value);
        if (huawei != null) huawei.setZIndex(value);
    }

    public float getZIndex() {
        float value = -1;
        if (google != null) value = google.getZIndex();
        if (huawei != null) value = huawei.getZIndex();
        return value;
    }

    public void setAlpha(float value) {
        if (google != null) google.setAlpha(value);
        if (huawei != null) huawei.setAlpha(value);
    }

    public float getAlpha() {
        float res = -1;
        if (google != null) res = google.getAlpha();
        if (huawei != null) res = huawei.getAlpha();
        return res;
    }

    public final void setTag(@Nullable Object value) {
        if (google != null) google.setTag(value);
        if (huawei != null) huawei.setTag(value);
    }

    @Nullable
    public final Object getTag() {
        Object res = null;
        if (google != null) res = google.getTag();
        if (huawei != null) res = huawei.getTag();
        return res;
    }

    public final void setVisible(boolean value) {
        if (google != null) google.setVisible(value);
        if (huawei != null) huawei.setVisible(value);
    }

    public void showInfoWindow() {
        if (google != null) google.showInfoWindow();
        else if (huawei != null) huawei.showInfoWindow();
    }

    public void remove() {
        if (google != null) google.remove();
        else if (huawei != null) huawei.remove();
    }
}
