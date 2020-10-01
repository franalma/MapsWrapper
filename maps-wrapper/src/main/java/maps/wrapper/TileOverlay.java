package maps.wrapper;


public class TileOverlay {
    com.google.android.gms.maps.model.TileOverlay google;
    com.huawei.hms.maps.model.TileOverlay huawei;

    TileOverlay(com.google.android.gms.maps.model.TileOverlay google, com.huawei.hms.maps.model.TileOverlay huawei) {
        this.google = google;
        this.huawei = huawei;
    }

    public final void setFadeIn(boolean value) {
        if (this.google != null) google.setFadeIn(value);
        if (this.huawei != null) huawei.setFadeIn(value);
    }

    public final void setTransparency(float value) {
        if (this.google != null) google.setTransparency(value);
        if (this.huawei != null) huawei.setTransparency(value);
    }

    public final float getZIndex() {
        if (google != null) return google.getZIndex();
        if (huawei != null) return huawei.getZIndex();
        throw new UnsupportedOperationException("Missing underlying GMS/HMS TileOverlay.");
    }

    public final void setZIndex(float value) {
        if (this.google != null) google.setZIndex(value);
        if (this.huawei != null) huawei.setZIndex(value);
    }
}
