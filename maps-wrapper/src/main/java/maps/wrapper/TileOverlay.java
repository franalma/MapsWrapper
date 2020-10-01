package maps.wrapper;


public class TileOverlay {
    com.google.android.gms.maps.model.TileOverlay google;
    com.huawei.hms.maps.model.TileOverlay huawei;

    TileOverlay(com.google.android.gms.maps.model.TileOverlay google, com.huawei.hms.maps.model.TileOverlay huawei) {
        this.google = google;
        this.huawei = huawei;
    }

    public void setFadeIn(boolean value) {
        if (this.google != null) google.setFadeIn(value);
        if (this.huawei != null) huawei.setFadeIn(value);
    }

    public void setTransparency(float value) {
        if (this.google != null) google.setTransparency(value);
        if (this.huawei != null) huawei.setTransparency(value);
    }
}
