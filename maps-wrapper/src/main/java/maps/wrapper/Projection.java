package maps.wrapper;

import android.graphics.Point;

public class Projection {
    com.huawei.hms.maps.Projection huawei;
    com.google.android.gms.maps.Projection google;

    Projection(com.huawei.hms.maps.Projection huawei,
               com.google.android.gms.maps.Projection google) {
        this.huawei = huawei;
        this.google = google;
    }

    public final LatLng fromScreenLocation(Point point) {
        LatLng latLng = null;
        if (google != null) {
            com.google.android.gms.maps.model.LatLng lg = google.fromScreenLocation(point);
            latLng = new LatLng(lg.latitude, lg.longitude);
        } else if (huawei != null) {
            com.huawei.hms.maps.model.LatLng lg = huawei.fromScreenLocation(point);
            latLng = new LatLng(lg.latitude, lg.longitude);
        }
        return latLng;
    }

    public final Point toScreenLocation(LatLng location) {
        Point point = null;
        if (google != null) {
            point = google.toScreenLocation(new com.google.android.gms.maps.model.LatLng(location.latitude, location.longitude));
        } else if (huawei != null) {
            point = huawei.toScreenLocation(new com.huawei.hms.maps.model.LatLng(location.latitude, location.longitude));
        }
        return point;
    }

    public final VisibleRegion getVisibleRegion() {
        VisibleRegion visibleRegion = null;
        if (google != null) {
            com.google.android.gms.maps.model.VisibleRegion gvr = google.getVisibleRegion();
            if (gvr == null) {
                visibleRegion = null;
            } else {
                visibleRegion = new VisibleRegion(
                        new LatLng(gvr.nearLeft.latitude, gvr.nearLeft.longitude),
                        new LatLng(gvr.nearRight.latitude, gvr.nearRight.longitude),
                        new LatLng(gvr.farLeft.latitude, gvr.farLeft.longitude),
                        new LatLng(gvr.farRight.latitude, gvr.farRight.longitude),
                        new LatLngBounds(
                                new LatLng(gvr.latLngBounds.southwest.latitude, gvr.latLngBounds.southwest.longitude),
                                new LatLng(gvr.latLngBounds.northeast.latitude, gvr.latLngBounds.northeast.longitude)
                        )
                );
            }
        } else if (huawei != null) {
            com.huawei.hms.maps.model.VisibleRegion hvr = huawei.getVisibleRegion();
            if (hvr == null) {
                visibleRegion = null;
            } else {
                visibleRegion = new VisibleRegion(
                        new LatLng(hvr.nearLeft.latitude, hvr.nearLeft.longitude),
                        new LatLng(hvr.nearRight.latitude, hvr.nearRight.longitude),
                        new LatLng(hvr.farLeft.latitude, hvr.farLeft.longitude),
                        new LatLng(hvr.farRight.latitude, hvr.farRight.longitude),
                        new LatLngBounds(
                                new LatLng(hvr.latLngBounds.southwest.latitude, hvr.latLngBounds.southwest.longitude),
                                new LatLng(hvr.latLngBounds.northeast.latitude, hvr.latLngBounds.northeast.longitude)
                        )
                );
            }
        }
        return visibleRegion;
    }
}
