package maps.wrapper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MarkerOptions {
    com.huawei.hms.maps.model.MarkerOptions huawei;
    com.google.android.gms.maps.model.MarkerOptions google;

    public MarkerOptions( ) {
        this.huawei = new com.huawei.hms.maps.model.MarkerOptions();
        this.google = new com.google.android.gms.maps.model.MarkerOptions();
    }

    public  MarkerOptions position(@NonNull LatLng value) {
        google = google.position(value.google);
        huawei = huawei.position(value.huawei);
       return this;
    }

    public  MarkerOptions zIndex(float value) {
        google = google.zIndex(value);
        huawei = huawei.zIndex(value);
        return this;
    }

    public final MarkerOptions icon(@Nullable BitmapDescriptor value) {
        google = google.icon(value.google);
        huawei = huawei.icon(value.huawei);
        return this;
    }

    public final MarkerOptions anchor(float x, float y) {
        google = google.anchor(x,y);
        huawei = huawei.anchorMarker(x,y);
        return this;
    }

    public final MarkerOptions infoWindowAnchor(float x, float y) {
        google = google.infoWindowAnchor(x,y);
        huawei = huawei.infoWindowAnchor(x,y);
        return this;
    }

    public final MarkerOptions title(@Nullable String value) {
        google = google.title(value);
        huawei = huawei.title(value);
        return this;
    }

    public final MarkerOptions snippet(@Nullable String value) {
        google = google.snippet(value);
        huawei = huawei.snippet(value);
        return this;
    }

    public final MarkerOptions draggable(boolean value) {
        google = google.draggable(value);
        huawei = huawei.draggable(value);
        return this;
    }

    public final MarkerOptions visible(boolean value) {
        google = google.visible(value);
        huawei = huawei.visible(value);
        return this;
    }

    public final MarkerOptions flat(boolean value) {
        google = google.flat(value);
        huawei = huawei.flat(value);
        return this;
    }

    public final MarkerOptions rotation(float value) {
        google = google.rotation(value);
        huawei = huawei.rotation(value);
        return this;
    }

    public final MarkerOptions alpha(float value) {
        google = google.alpha(value);
        huawei = huawei.alpha(value);
        return this;
    }

}
