package maps.wrapper;


public class GroundOverlayOptions {
    com.huawei.hms.maps.model.GroundOverlayOptions huawei;
    com.google.android.gms.maps.model.GroundOverlayOptions google;

    public GroundOverlayOptions() {
        google = new com.google.android.gms.maps.model.GroundOverlayOptions();
        huawei = new com.huawei.hms.maps.model.GroundOverlayOptions();
    }


    public final GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            if (google != null && bitmapDescriptor.google != null)
                google = google.image(bitmapDescriptor.google);
            if (huawei != null && bitmapDescriptor.huawei != null)
                huawei = huawei.image(bitmapDescriptor.huawei);
        }

        return this;
    }

    public final GroundOverlayOptions position(LatLng latLng, float length) {
        if (google != null) google = google.position(latLng.google, length);
        if (huawei != null) huawei = huawei.position(latLng.huawei, length);
        return this;
    }

    public final GroundOverlayOptions clickable(boolean value) {
        if (google != null) google = google.clickable(value);
        if (huawei != null) huawei = huawei.clickable(value);
        return this;
    }

    public final GroundOverlayOptions anchor(float value1, float value2) {
        if (google != null) google = google.anchor(value1, value2);
        if (huawei != null) huawei = huawei.anchor(value1, value2);
        return this;
    }

    public final GroundOverlayOptions position(LatLng latLng, float value1, float value2) {
        if (google != null) google = google.position(latLng.google, value1, value2);
        if (huawei != null) huawei = huawei.position(latLng.huawei, value1, value2);
        return this;
    }

    public final GroundOverlayOptions bearing(float value) {
        if (google != null) google = google.bearing(value);
        if (huawei != null) huawei = huawei.bearing(value);
        return this;
    }

    public final void zIndex(float value) {
        if (google != null) google.zIndex(value);
        if (huawei != null) huawei.zIndex(value);
    }

    public final float getZIndex() {
        if (google != null) return google.getZIndex();
        if (huawei != null) return huawei.getZIndex();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS Polygon.");
    }
}