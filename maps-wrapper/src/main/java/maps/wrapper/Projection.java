package maps.wrapper;

import android.graphics.Point;

public class Projection {
    com.huawei.hms.maps.Projection huawei;
    com.google.android.gms.maps.Projection google;

    public Projection(com.huawei.hms.maps.Projection huawei,
                      com.google.android.gms.maps.Projection google) {
        this.huawei = huawei;
        this.google = google;
    }

    public LatLng fromScreenLocation(Point point){
        LatLng latLng = null;
        if (google != null) {
            com.google.android.gms.maps.model.LatLng lg = google.fromScreenLocation(point);
            latLng = new LatLng(lg.latitude, lg.longitude);
        }else if(huawei != null){
            com.huawei.hms.maps.model.LatLng lg = huawei.fromScreenLocation(point);
            latLng = new LatLng(lg.latitude, lg.longitude);
        }
        return latLng;
    }
}
